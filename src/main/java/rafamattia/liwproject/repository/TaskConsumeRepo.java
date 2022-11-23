package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Material;
import rafamattia.liwproject.models.TaskConsume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskConsumeRepo {
    public static void consume(int taskId, int materialId, int quantityUsed) {
        String sql = "INSERT INTO utiliza (COD_MATERIAL, COD_SERVICO, QTD_UTILIZADO) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);

            //Remove do do estoque a quantidade de material utilizda
            MaterialRepo.updateAmountByMaterialId(materialId, -quantityUsed);

            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, materialId);
            pstm.setInt(2, taskId);
            pstm.setFloat(3, quantityUsed);

            //executar a query
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println("A quantidade utilizada foi registrada!!!");
            //fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void getTaskConsumeTotalValue(int taskId) {
        float totalValue=0f;
        for (TaskConsume task : TaskConsumeRepo.getTaskConsumeList(taskId)) {
            totalValue += task.getValue()*task.getQuantityUsed();
            System.out.println("ID: " + task.getMaterialId() + " || Nome: " + task.getName() + " || Quantidade utilizda: " + task.getQuantityUsed() + " || Valor unitário: " + task.getValue());
        }
        System.out.println("Valor total dos materiais utilizados: " + totalValue);
    }

    public static List<TaskConsume> getTaskConsumeList(int taskId){
        String sql = "SELECT * FROM utiliza WHERE COD_SERVICO = ?";
        List<TaskConsume> taskConsumes = new ArrayList<TaskConsume>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****

        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, taskId);

            rset = pstm.executeQuery();

            while(rset.next()){
                TaskConsume taskConsume = new TaskConsume();

                //LOCALIZA O MATERIAL PARA ASSIM CONSEGUIR O VALOR DELE
                Material material = MaterialRepo.findMaterialById(rset.getInt("COD_MATERIAL"));

                //Recupera o Nome do material
                taskConsume.setName(material.getName());
                //Recupera o ID do serviço
                taskConsume.setTaskId(rset.getInt("COD_SERVICO"));
                //Recupera o ID do material
                taskConsume.setMaterialId(rset.getInt("COD_MATERIAL"));
                //Recupera a quantidade utilizada do material
                taskConsume.setQuantityUsed(rset.getInt("QTD_UTILIZADO"));
                //Recupera o valor do material
                taskConsume.setValue(material.getValue());

                //adiciona na lista
                taskConsumes.add(taskConsume);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rset!=null) {
                    rset.close();
                }
                if(pstm != null) {
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return taskConsumes;
    }

}
