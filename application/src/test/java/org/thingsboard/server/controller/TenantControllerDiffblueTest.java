package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TenantControllerDiffblueTest {
  @InjectMocks
  private TenantController tenantController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TenantController#saveTenant(Tenant)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantController#saveTenant(Tenant)}
   */
  @Test
  @DisplayName("Test saveTenant(Tenant); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tenant TenantController.saveTenant(Tenant)"})
  void testSaveTenant_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/tenant");
    postResult.characterEncoding("https://example.org/example");

    Tenant tenant = new Tenant();
    tenant.setAddress("42 Main St");
    tenant.setAddress2("42 Main St");
    tenant.setCity("Oxford");
    tenant.setCountry("GB");
    tenant.setCreatedTime(1L);
    tenant.setEmail("jane.doe@example.org");
    tenant.setId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenant.setPhone("6625550144");
    tenant.setRegion("us-east-2");
    tenant.setState("MD");
    tenant.setTenantProfileId(null);
    tenant.setTitle("Dr");
    tenant.setVersion(1L);
    tenant.setZip("21654");
    String content = (new ObjectMapper()).writeValueAsString(tenant);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }
}
