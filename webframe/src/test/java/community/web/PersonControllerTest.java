package community.web;

import com.andy.jay.util.JsonHelper;
import com.andy.jay.web.dto.Person;
import com.andy.jay.web.dto.Result;
import community.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class PersonControllerTest extends BaseTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }


    @Test
    public void testGetPerson() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/person/list")
                .param("personId", "1"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Result result = JsonHelper.getInstance().toGenericObject(content, Person.class);
        Assert.assertEquals(true, result.isSuccess());
        List<Person> data = (List<Person>) result.getData();
        String json = JsonHelper.getInstance().toString(data);
        System.out.println("return data size:" + data.size());
    }


}
