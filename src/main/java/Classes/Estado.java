/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.compensar.redsocial.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Estado {

    private int id;
    private String name;
    private String short_name;
    private String description;

    public Estado(int id, String name, String short_name, String description) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return short_name;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Estado> getEstados() throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM estados");
        ArrayList<Estado> array_result = new ArrayList<>();
        while (result.next()) {
            array_result.add(
                    new Estado(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4)
                    )
            );
        }
        return array_result;
    }

}
