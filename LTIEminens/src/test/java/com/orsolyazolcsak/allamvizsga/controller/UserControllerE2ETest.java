package com.orsolyazolcsak.allamvizsga.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.orsolyazolcsak.allamvizsga.Application;
import com.orsolyazolcsak.allamvizsga.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserControllerE2ETest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private UserService userService;

  @Before
  public void setUp() {
    this.userService.deleteAll();
  }

  @Test
  public void whenCreateNewUser_thenItIsCreated() throws Exception {
    this.mvc.perform(MockMvcRequestBuilders.post("/register").content(EntityUtils.toString(
        new UrlEncodedFormEntity(Arrays.asList(new BasicNameValuePair("fullName", "full name"),
            new BasicNameValuePair("password", "pw"), new BasicNameValuePair("username", "u"),
            new BasicNameValuePair("roleId", "1"))))).contentType(
                MediaType.APPLICATION_FORM_URLENCODED).accept(
                    MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(
                        MockMvcResultMatchers.jsonPath("$").exists());
  }

}
