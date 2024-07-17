package com.example.demo.springjpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian")
        )
        //same thing to other columns to map in db
        //notice same thing in Test class as name changed
})
@Builder
public class Guardian {
    //embedded this class to student class to be in same table
    //now we can name this as name,mail,phone as used in students (name,mail,phone)different class
    //but we need to map it

    private String name; //guardian
    private String guardianmail;
    private String phone;
}
