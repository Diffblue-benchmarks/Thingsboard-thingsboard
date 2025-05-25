package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mClientDiffblueTest {
  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", null);

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "Endpoint");

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Different type to LwM2mClient");
  }
}
