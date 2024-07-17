package com.example.demo.springjpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "tbl_student", // new table is created in this name
//         uniqueConstraints = @UniqueConstraint(
//                 name = "emailid_unique",
//                 columnNames = "email_address"
//)
// )
public class Student {

    @Id //primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String mailid;

//  @Column(name="email_address",
//  nullable =false
//  ) this will name column in db as email_address


    //This guardian details need to be in different class but need be in same table so we use embeddable
//    private String guardian;
//    private String guardianmail;
//    private String phone;

    @Embedded
    private Guardian guardian;
}
