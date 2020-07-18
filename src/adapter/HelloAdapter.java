package adapter;

import database.DatabaseAdapter;
import model.mdlTblWaArtikel;

import javax.sql.rowset.CachedRowSet;


public class HelloAdapter {

    public static String GetDataArtikel (){
        String id = "";
        String sql = "";
        CachedRowSet rowSet =  null;

        try {

            sql = "{call sp_get_artikel_all()}";

            rowSet = DatabaseAdapter.getConnectionMsql2(sql);

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
}
