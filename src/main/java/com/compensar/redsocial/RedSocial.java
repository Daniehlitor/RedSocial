/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.compensar.redsocial;

/**
 *
 * @author Daniel
 */
public class RedSocial {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jbdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
