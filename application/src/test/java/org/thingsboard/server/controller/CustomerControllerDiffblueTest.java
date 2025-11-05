package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.customer.DefaultTbCustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerDiffblueTest {
  @InjectMocks private CustomerController customerController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link CustomerController#getCustomerById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerById(String)}
   */
  @Test
  @DisplayName("Test getCustomerById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.getCustomerById(String)"})
  void testGetCustomerById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link CustomerController#getCustomerById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerById(String)}
   */
  @Test
  @DisplayName("Test getCustomerById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.getCustomerById(String)"})
  void testGetCustomerById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link CustomerController#getCustomerById(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomerById(String)}
   */
  @Test
  @DisplayName("Test getCustomerById(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.getCustomerById(String)"})
  void testGetCustomerById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link CustomerController#getCustomerById(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomerById(String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerById(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.getCustomerById(String)"})
  void testGetCustomerById_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName("Test getShortCustomerInfoById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode CustomerController.getShortCustomerInfoById(String)"
  })
  void testGetShortCustomerInfoById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName("Test getShortCustomerInfoById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode CustomerController.getShortCustomerInfoById(String)"
  })
  void testGetShortCustomerInfoById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName("Test getShortCustomerInfoById(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode CustomerController.getShortCustomerInfoById(String)"
  })
  void testGetShortCustomerInfoById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName(
      "Test getShortCustomerInfoById(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode CustomerController.getShortCustomerInfoById(String)"
  })
  void testGetShortCustomerInfoById_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName("Test getCustomerTitleById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerController.getCustomerTitleById(String)"})
  void testGetCustomerTitleById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName("Test getCustomerTitleById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerController.getCustomerTitleById(String)"})
  void testGetCustomerTitleById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName("Test getCustomerTitleById(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerController.getCustomerTitleById(String)"})
  void testGetCustomerTitleById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerTitleById(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerController.getCustomerTitleById(String)"})
  void testGetCustomerTitleById_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link CustomerController#saveCustomer(Customer)}.
   *
   * <p>Method under test: {@link CustomerController#saveCustomer(Customer)}
   */
  @Test
  @DisplayName("Test saveCustomer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.saveCustomer(Customer)"})
  void testSaveCustomer() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CustomerController customerController = new CustomerController(new DefaultTbCustomerService());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> customerController.saveCustomer(new Customer()));
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName("Test deleteCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerController.deleteCustomer(String)"})
  void testDeleteCustomer() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName("Test deleteCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerController.deleteCustomer(String)"})
  void testDeleteCustomer2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName("Test deleteCustomer(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerController.deleteCustomer(String)"})
  void testDeleteCustomer_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName(
      "Test deleteCustomer(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerController.deleteCustomer(String)"})
  void testDeleteCustomer_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomers(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new CustomerController(new DefaultTbCustomerService())
                .getCustomers(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomers(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new CustomerController(new DefaultTbCustomerService())
                .getCustomers(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomers(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new CustomerController(new DefaultTbCustomerService())
                .getCustomers(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomers(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new CustomerController(new DefaultTbCustomerService())
                .getCustomers(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomers(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new CustomerController(new DefaultTbCustomerService())
                .getCustomers(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link CustomerController#getTenantCustomer(String)}.
   *
   * <p>Method under test: {@link CustomerController#getTenantCustomer(String)}
   */
  @Test
  @DisplayName("Test getTenantCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerController.getTenantCustomer(String)"})
  void testGetTenantCustomer() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new CustomerController(new DefaultTbCustomerService()).getTenantCustomer("Dr"));
  }
}
