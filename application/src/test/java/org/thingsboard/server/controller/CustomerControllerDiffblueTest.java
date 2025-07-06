package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link CustomerController#getCustomerById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerById(String)}
   */
  @Test
  @DisplayName("Test getCustomerById(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName("Test getShortCustomerInfoById(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link CustomerController#getShortCustomerInfoById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getShortCustomerInfoById(String)}
   */
  @Test
  @DisplayName("Test getShortCustomerInfoById(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName("Test getCustomerTitleById(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link CustomerController#getCustomerTitleById(String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomerTitleById(String)}
   */
  @Test
  @DisplayName("Test getCustomerTitleById(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link CustomerController#saveCustomer(Customer)}.
   *
   * <p>Method under test: {@link CustomerController#saveCustomer(Customer)}
   */
  @Test
  @DisplayName("Test saveCustomer(Customer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Customer CustomerController.saveCustomer(Customer)"})
  void testSaveCustomer() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/customer");
    postResult.characterEncoding("https://example.org/example");

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setAddress2("42 Main St");
    customer.setCity("Oxford");
    customer.setCountry("GB");
    customer.setCreatedTime(1L);
    customer.setEmail("jane.doe@example.org");
    customer.setExternalId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    customer.setPhone("6625550144");
    customer.setState("MD");
    customer.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    customer.setTitle("Dr");
    customer.setVersion(1L);
    customer.setZip("21654");
    String content = new ObjectMapper().writeValueAsString(customer);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName("Test deleteCustomer(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link CustomerController#deleteCustomer(String)}.
   *
   * <p>Method under test: {@link CustomerController#deleteCustomer(String)}
   */
  @Test
  @DisplayName("Test deleteCustomer(String)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isNotFound());
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link CustomerController#getCustomers(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerController#getCustomers(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomers(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData CustomerController.getCustomers(int, int, String, String, String)"
  })
  void testGetCustomers() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customers").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
