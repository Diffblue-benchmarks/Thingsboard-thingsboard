package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.domain.DomainServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.domain.DefaultTbDomainService;

@ExtendWith(MockitoExtension.class)
class DomainControllerDiffblueTest {
  @InjectMocks private DomainController domainController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DomainController#saveDomain(Domain, UUID[])}.
   *
   * <p>Method under test: {@link DomainController#saveDomain(Domain, UUID[])}
   */
  @Test
  @DisplayName("Test saveDomain(Domain, UUID[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Domain DomainController.saveDomain(Domain, UUID[])"})
  void testSaveDomain() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DomainController domainController =
        new DomainController(new DefaultTbDomainService(new DomainServiceImpl()));
    Domain domain = new Domain();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            domainController.saveDomain(
                domain, new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));
  }

  /**
   * Test {@link DomainController#getTenantDomainInfos(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link DomainController#getTenantDomainInfos(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getTenantDomainInfos(int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DomainController.getTenantDomainInfos(int, int, String, String, String)"
  })
  void testGetTenantDomainInfos() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new DomainController(new DefaultTbDomainService(new DomainServiceImpl()))
                .getTenantDomainInfos(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link DomainController#getDomainInfoById(UUID)}.
   *
   * <p>Method under test: {@link DomainController#getDomainInfoById(UUID)}
   */
  @Test
  @DisplayName("Test getDomainInfoById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainInfo DomainController.getDomainInfoById(UUID)"})
  void testGetDomainInfoById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/domain/info/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link DomainController#deleteDomain(UUID)}.
   *
   * <p>Method under test: {@link DomainController#deleteDomain(UUID)}
   */
  @Test
  @DisplayName("Test deleteDomain(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainController.deleteDomain(UUID)"})
  void testDeleteDomain() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/domain/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(domainController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }
}
