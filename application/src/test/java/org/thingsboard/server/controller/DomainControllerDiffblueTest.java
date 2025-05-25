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
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class DomainControllerDiffblueTest {
  @InjectMocks
  private DomainController domainController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DomainController#saveDomain(Domain, UUID[])}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainController#saveDomain(Domain, UUID[])}
   */
  @Test
  @DisplayName("Test saveDomain(Domain, UUID[]); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Domain DomainController.saveDomain(Domain, UUID[])"})
  void testSaveDomain_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/domain");
    postResult.characterEncoding("https://example.org/example");

    Domain domain = new Domain();
    domain.setCreatedTime(1L);
    domain.setId(null);
    domain.setName("Name");
    domain.setOauth2Enabled(true);
    domain.setPropagateToEdge(true);
    domain.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = (new ObjectMapper()).writeValueAsString(domain);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DomainController#updateOauth2Clients(UUID, UUID[])}.
   * <p>
   * Method under test: {@link DomainController#updateOauth2Clients(UUID, UUID[])}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(UUID, UUID[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DomainController.updateOauth2Clients(UUID, UUID[])"})
  void testUpdateOauth2Clients() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
        .put("/api/domain/{id}/oauth2Clients", "Uri Variables", "Uri Variables")
        .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder = contentTypeResult
        .content(objectMapper.writeValueAsString(new UUID[]{UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DomainController#getTenantDomainInfos(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link DomainController#getTenantDomainInfos(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantDomainInfos(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData DomainController.getTenantDomainInfos(int, int, String, String, String)"})
  void testGetTenantDomainInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/domain/infos")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
