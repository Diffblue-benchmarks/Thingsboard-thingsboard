package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class UserControllerDiffblueTest {
  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks
  private UserController userController;

  /**
   * Test {@link UserController#getUserById(String)}.
   * <p>
   * Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.User UserController.getUserById(String)"})
  void testGetUserById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   * <p>
   * Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.User UserController.getUserById(String)"})
  void testGetUserById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.User UserController.getUserById(String)"})
  void testGetUserById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.User UserController.getUserById(String)"})
  void testGetUserById_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   * <p>
   * Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   * <p>
   * Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   * <p>
   * Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"})
  void testGetActivationLinkInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   * <p>
   * Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"})
  void testGetActivationLinkInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"})
  void testGetActivationLinkInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"})
  void testGetActivationLinkInfo_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   * <p>
   * Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   * <p>
   * Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#findUsersByQuery(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link UserController#findUsersByQuery(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test findUsersByQuery(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.findUsersByQuery(int, int, String, String, String)"})
  void testFindUsersByQuery() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/users/info")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link UserController#getTenantAdmins(String, int, int, String, String, String)}.
   * <p>
   * Method under test: {@link UserController#getTenantAdmins(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantAdmins(String, int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getTenantAdmins(String, int, int, String, String, String)"})
  void testGetTenantAdmins() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/tenant/{tenantId}/users", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getTenantAdmins(String, int, int, String, String, String)}.
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getTenantAdmins(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantAdmins(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getTenantAdmins(String, int, int, String, String, String)"})
  void testGetTenantAdmins_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/tenant/{tenantId}/users", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getTenantAdmins(String, int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then status four hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getTenantAdmins(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantAdmins(String, int, int, String, String, String); when '42'; then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getTenantAdmins(String, int, int, String, String, String)"})
  void testGetTenantAdmins_when42_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/tenant/{tenantId}/users", "42")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link UserController#getCustomerUsers(String, int, int, String, String, String)}.
   * <p>
   * Method under test: {@link UserController#getCustomerUsers(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerUsers(String, int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getCustomerUsers(String, int, int, String, String, String)"})
  void testGetCustomerUsers() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/customer/{customerId}/users", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getCustomerUsers(String, int, int, String, String, String)}.
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getCustomerUsers(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerUsers(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getCustomerUsers(String, int, int, String, String, String)"})
  void testGetCustomerUsers_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/customer/{customerId}/users", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getCustomerUsers(String, int, int, String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then status four hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getCustomerUsers(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerUsers(String, int, int, String, String, String); when '42'; then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData UserController.getCustomerUsers(String, int, int, String, String, String)"})
  void testGetCustomerUsers_when42_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/customer/{customerId}/users", "42")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code strType}.
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code strType}.
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code strType}.
   * <ul>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code strType}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'; then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'; then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'; when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   * <p>
   * Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"})
  void testGetUserDashboardsInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   * <p>
   * Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"})
  void testGetUserDashboardsInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"})
  void testGetUserDashboardsInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"})
  void testGetUserDashboardsInfo_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }
}
