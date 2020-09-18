package adapter;

import database.DatabaseAdapter;
import model.mdlBarang;
import model.mdlProduct;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter {

    public static List<mdlProduct> GetProductListDepan (){

        String sql  = "";
        List<mdlProduct> _mdlProductList = new ArrayList<>();
        CachedRowSet rowSet =  null;

        try{
            sql = "SELECT * FROM tbl_product_depan";

            rowSet = DatabaseAdapter.getExecute(sql);

            while (rowSet.next()){
                mdlProduct _mdlProduct =  new mdlProduct();

                _mdlProduct.productID = rowSet.getString("product_id");
                _mdlProduct.productName = rowSet.getString("product_name");
                _mdlProduct.productDesc = rowSet.getString("product_desc");
                _mdlProduct.productPrice = rowSet.getString("product_price");
                _mdlProduct.imagePath = rowSet.getString("image_path");
                _mdlProduct.createdBY = rowSet.getString("created_by");
                _mdlProduct.createdDate = rowSet.getString("created_date");
                _mdlProduct.updatedBY = rowSet.getString("updated_by");
                _mdlProduct.updatedDate = rowSet.getString("updated_date");
                _mdlProduct.isActive = rowSet.getString("is_active");

                _mdlProductList.add(_mdlProduct);

            }

        }catch (Exception ex){
            _mdlProductList = null;
            ex.getMessage();
        }

        return _mdlProductList;
    }

    public static List<mdlBarang> GetBarangList (){

        String sql  = "";
        List<mdlBarang> _mdlBarangList = new ArrayList<>();
        CachedRowSet rowSet =  null;

        try{
            sql = "SELECT * FROM tbl_barang";

            rowSet = DatabaseAdapter.getExecute(sql);

            while (rowSet.next()){
                mdlBarang _mdlBarang =  new mdlBarang();

                _mdlBarang.ID = rowSet.getString("ID");
                _mdlBarang.namaBarang = rowSet.getString("NamaBarang");
                _mdlBarang.image = rowSet.getString("Image");

                _mdlBarangList.add(_mdlBarang);

            }

        }catch (Exception ex){
            _mdlBarangList = null;
            ex.getMessage();
        }

        return _mdlBarangList;
    }
}
