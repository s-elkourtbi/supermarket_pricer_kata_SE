package ingeniance.supermarche.ingenianceDemo.restTest;

import ingeniance.supermarche.ingenianceDemo.Dto.PriceRuleDTO;
import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;
import ingeniance.supermarche.ingenianceDemo.rest.PriceRuleRest;
import ingeniance.supermarche.ingenianceDemo.service.PriceRuleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
public class PriceRuleRestTest {

    @Mock
    private PriceRuleService priceRuleService;

    @InjectMocks
    private PriceRuleRest priceRuleController;

    private MockMvc mockMvc;

    private PriceRuleDTO priceRuleDTO;


    @BeforeEach
    public void setUp() {
        priceRuleDTO = new PriceRuleDTO();
        priceRuleDTO.setIdPriceRule(1L);
        priceRuleDTO.setDescription("simple pricing");
        priceRuleDTO.setType(PriceRuleType.SIMPLE);
        priceRuleDTO.setSimplePrice(0.65f);
    }

    @Test
    void testUpdateTypeRule() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceRuleController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/pricing/updateTypeRule/1")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("type", "SIMPLE")).andReturn();
        Assertions.assertEquals(HttpStatus.ACCEPTED.value(), result.getResponse().getStatus());

    }

    @Test
    void testUpdatePriceRule() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceRuleController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/pricing/updatePriceRule/1")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("price", "0.36")).andReturn();
        Assertions.assertEquals(HttpStatus.ACCEPTED.value(), result.getResponse().getStatus());
    }

    @Test
    void testDeletePriceRule() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(priceRuleController).build();

        doNothing().when(priceRuleService).deletePriceRuleById(1L);

        mockMvc.perform(delete("/api/pricing/deletetPriceRule/1"))
                .andExpect(status().isNoContent());

        verify(priceRuleService, times(1)).deletePriceRuleById(1L);
    }

    @Test
    public void testCreatNewPriceRule() throws Exception {
        String priceRule = "{\"idPriceRule\":1,\"description\":\"Regularprice\",\"type\":\"SIMPLE\",\"simplePrice\":63.0}";
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceRuleController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/pricing/newPriceRule")
                .content(priceRule)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(HttpStatus.ACCEPTED.value(), result.getResponse().getStatus());
    }


    @Test
    public void testgetPriceRuleById() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceRuleController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/pricing/newPriceRule")
                .content("{\"idPriceRule\":1,\"description\":\"Regularprice\",\"type\":\"SIMPLE\",\"simplePrice\":63.0}")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        Assertions.assertEquals(HttpStatus.ACCEPTED.value(), result.getResponse().getStatus());
    }

}
