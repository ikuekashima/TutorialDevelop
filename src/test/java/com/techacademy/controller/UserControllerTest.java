package com.techacademy.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.techacademy.entity.User;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;

    private final WebApplicationContext webApplicationContext;

    UserControllerTest(WebApplicationContext context) {
        this.webApplicationContext = context;
    }

    @BeforeEach
    void beforeEach() {
        // Spring Securityを有効にする
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity()).build();
    }

    @Test
    @DisplayName("User更新画面")
    @WithMockUser
    void testGetUser() throws Exception {
        // HTTPリクエストに対するレスポンスの検証

       // MvcResult result = //
        mockMvc.perform(get("/user/update/1/")) // URLにアクセス
            .andExpect(status().isOk()) // ステータスを確認
            .andExpect(model().attributeExists("user")) // Modelの内容を確認
            .andExpect(model().hasNoErrors()) // Modelのエラー有無の確認
            .andExpect(view().name("user/update")) // viewの確認
            .andReturn(); // 内容の取得

        MvcResult result = null;
        // userの検証
        // Modelからuserを取り出す
        //User user = (User)result.getModelAndView().getModel().get("user");
        //assertEquals(1, user.getId());
        //assertEquals("キラメキ太郎", user.getName());
    }


    /*getList() メソッドに対するテスト

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("User更新画面")
    @WithMockUser
    void testGetUser() throws Exception {
        // モックデータ作成
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("キラメキ太郎");

        // モックサービス設定
        when(userService.getUser(1)).thenReturn(mockUser);

        // テスト実行
        mockMvc.perform(get("/user/update/1"))
            .andExpect(status().isOk()) // ステータス200を期待
            .andExpect(model().attributeExists("user")) // Modelに"user"が存在することを確認
            .andExpect(model().attribute("user", mockUser)) // モックデータと一致していることを確認
            .andExpect(view().name("user/update")); // View名を確認
    }
}

viewの名前が user/list であること

件数が3件であること
userlistから1件ずつ取り出し、idとnameを検証する*/
    @Test
    @WithMockUser
    void testGetList() throws Exception {

        MvcResult result = mockMvc.perform(get("/user/update/1")) // URLにアクセス
                //.andExpect(status().isOk()) // ステータスを確認 HTTPステータスが200OKであること//
                //.andExpect(model().attributeExists("userlist")) //  // Modelの内容を確認 Modelにuserlistが含まれていること//
                //.andExpect(model().hasNoErrors())// // Modelのエラー有無の確認//
                //.andExpect(view().name("user/list")) // viewの確認//
                .andReturn(); // 内容の取得//





            // Modelからuserlistを取り出す Modelからuserlistを取り出す
            //User userlist = (User)result.getModelAndView().getModel().get("userlist");//


            //List<User> userlist = extracted(result);//


            //assertEquals(1, ((ApplicationContext) userlist).getId());
            //assertEquals("キラメキ太郎", ((User) userlist).getName());
        }

    private List<User> extracted(MvcResult result) {
        return (List<User>) result.getModelAndView().getModel().get("userlist");
    }
    }
