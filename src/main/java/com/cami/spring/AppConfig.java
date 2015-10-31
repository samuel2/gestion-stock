/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@EnableWebMvc
@Configuration
@ComponentScan
@Import({PersistenceJPAConfig.class})
public class AppConfig {

}
