package org.thingsboard.server.common.data.sms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestSmsRequestDiffblueTest {
  /**
   * Test {@link TestSmsRequest#equals(Object)}, and {@link TestSmsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}, and {@link TestSmsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage(null);
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage(null);
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}, and {@link TestSmsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo(null);
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo(null);
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}, and {@link TestSmsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest.hashCode());
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("42");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage(null);
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("alice.liddell@example.org");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo(null);
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, null);
  }

  /**
   * Test {@link TestSmsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TestSmsRequest.equals(Object)", "int TestSmsRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, "Different type to TestSmsRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TestSmsRequest}
   *   <li>{@link TestSmsRequest#setMessage(String)}
   *   <li>{@link TestSmsRequest#setNumberTo(String)}
   *   <li>{@link TestSmsRequest#setProviderConfiguration(SmsProviderConfiguration)}
   *   <li>{@link TestSmsRequest#toString()}
   *   <li>{@link TestSmsRequest#getMessage()}
   *   <li>{@link TestSmsRequest#getNumberTo()}
   *   <li>{@link TestSmsRequest#getProviderConfiguration()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TestSmsRequest.<init>()",
    "String TestSmsRequest.getMessage()",
    "String TestSmsRequest.getNumberTo()",
    "SmsProviderConfiguration TestSmsRequest.getProviderConfiguration()",
    "void TestSmsRequest.setMessage(String)",
    "void TestSmsRequest.setNumberTo(String)",
    "void TestSmsRequest.setProviderConfiguration(SmsProviderConfiguration)",
    "String TestSmsRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TestSmsRequest actualTestSmsRequest = new TestSmsRequest();
    actualTestSmsRequest.setMessage("Not all who wander are lost");
    actualTestSmsRequest.setNumberTo("42");
    SmsProviderConfiguration providerConfiguration = mock(SmsProviderConfiguration.class);
    actualTestSmsRequest.setProviderConfiguration(providerConfiguration);
    actualTestSmsRequest.toString();
    String actualMessage = actualTestSmsRequest.getMessage();
    String actualNumberTo = actualTestSmsRequest.getNumberTo();

    // Assert
    assertEquals("42", actualNumberTo);
    assertEquals("Not all who wander are lost", actualMessage);
    assertSame(providerConfiguration, actualTestSmsRequest.getProviderConfiguration());
  }
}
