package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContactBasedDiffblueTest {
  /**
   * Test {@link ContactBased#setCountry(String)}.
   *
   * <p>Method under test: {@link ContactBased#setCountry(String)}
   */
  @Test
  @DisplayName("Test setCountry(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setCountry(String)"})
  void testSetCountry() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setCountry("GB");

    // Assert
    assertEquals("GB", customer.getCountry());
  }

  /**
   * Test {@link ContactBased#setState(String)}.
   *
   * <p>Method under test: {@link ContactBased#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setState(String)"})
  void testSetState() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setState("MD");

    // Assert
    assertEquals("MD", customer.getState());
  }

  /**
   * Test {@link ContactBased#setCity(String)}.
   *
   * <p>Method under test: {@link ContactBased#setCity(String)}
   */
  @Test
  @DisplayName("Test setCity(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setCity(String)"})
  void testSetCity() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setCity("Oxford");

    // Assert
    assertEquals("Oxford", customer.getCity());
  }

  /**
   * Test {@link ContactBased#setAddress(String)}.
   *
   * <p>Method under test: {@link ContactBased#setAddress(String)}
   */
  @Test
  @DisplayName("Test setAddress(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setAddress(String)"})
  void testSetAddress() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAddress("42 Main St");

    // Assert
    assertEquals("42 Main St", customer.getAddress());
  }

  /**
   * Test {@link ContactBased#setAddress2(String)}.
   *
   * <p>Method under test: {@link ContactBased#setAddress2(String)}
   */
  @Test
  @DisplayName("Test setAddress2(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setAddress2(String)"})
  void testSetAddress2() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAddress2("42 Main St");

    // Assert
    assertEquals("42 Main St", customer.getAddress2());
  }

  /**
   * Test {@link ContactBased#setZip(String)}.
   *
   * <p>Method under test: {@link ContactBased#setZip(String)}
   */
  @Test
  @DisplayName("Test setZip(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setZip(String)"})
  void testSetZip() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setZip("21654");

    // Assert
    assertEquals("21654", customer.getZip());
  }

  /**
   * Test {@link ContactBased#setPhone(String)}.
   *
   * <p>Method under test: {@link ContactBased#setPhone(String)}
   */
  @Test
  @DisplayName("Test setPhone(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setPhone(String)"})
  void testSetPhone() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setPhone("6625550144");

    // Assert
    assertEquals("6625550144", customer.getPhone());
  }

  /**
   * Test {@link ContactBased#setEmail(String)}.
   *
   * <p>Method under test: {@link ContactBased#setEmail(String)}
   */
  @Test
  @DisplayName("Test setEmail(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ContactBased.setEmail(String)"})
  void testSetEmail() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setEmail("jane.doe@example.org");

    // Assert
    assertEquals("jane.doe@example.org", customer.getEmail());
  }
}
