package com.example.tuni_rand.domain;



import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn( name = "id" )
public class Admin extends  User {

    public Admin() {
    }


}
