package adapter;

import database.DatabaseAdapter;
import model.mdlListParam;
import model.mdlTblWaArtikel;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.List;


public class HelloAdapter {

    public static String GetDataArtikel (){
        String id = "";
        String sql = "";
        CachedRowSet rowSet =  null;

        try {

            sql = "{call sp_get_artikel_all()}";

            rowSet = DatabaseAdapter.getExecute(sql);

            while (rowSet.next()){

                mdlTblWaArtikel _mdlTblWaArtikel = new mdlTblWaArtikel();

                _mdlTblWaArtikel.id_artikel = rowSet.getString("id_artikel");

                id = _mdlTblWaArtikel.id_artikel;
            }

        }catch (Exception ex){
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public static boolean uploadDataArtikel (mdlTblWaArtikel param){
        String sql  = "";
        boolean resultExc =  false;
        List<mdlListParam> listParam = new ArrayList<>();

        try {
            sql = "{}";

            listParam.add(DatabaseAdapter.getParamSql("string", param.id_artikel));
            listParam.add(DatabaseAdapter.getParamSql("string", param.judul_artikel));

            resultExc = DatabaseAdapter.uploadExecute(sql, listParam);


        }catch (Exception ex){
            ex.getMessage();
        }
        return  resultExc;
    }
}
