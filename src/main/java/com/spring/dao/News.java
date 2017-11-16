//package com.spring.dao;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
///**
// * Created by arman 04.11.17.
// */
//@Entity
//@Table(name = "news")
//public class News {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "content")
//    private String content;
//
//    @Column(name = "post_date")
//    private Timestamp postDate;
//
//    @Column(name = "active")
//    private boolean isActive;
//
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Long company_id;
//
//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Long admin_id;
//
//
//}
