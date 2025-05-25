package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GeneralNotificationInfoDiffblueTest {
  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}, and {@link GeneralNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();
    GeneralNotificationInfo generalNotificationInfo2 = new GeneralNotificationInfo();

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo2);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo2.hashCode());
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}, and {@link GeneralNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo(new HashMap<>());
    GeneralNotificationInfo generalNotificationInfo2 = new GeneralNotificationInfo(new HashMap<>());

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo2);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo2.hashCode());
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}, and {@link GeneralNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo.hashCode());
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo(new HashMap<>());

    // Act and Assert
    assertNotEquals(generalNotificationInfo, new GeneralNotificationInfo());
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();

    // Act and Assert
    assertNotEquals(generalNotificationInfo, new GeneralNotificationInfo(new HashMap<>()));
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneralNotificationInfo(), null);
  }

  /**
   * Test {@link GeneralNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeneralNotificationInfo.equals(Object)", "int GeneralNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneralNotificationInfo(), "Different type to GeneralNotificationInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#GeneralNotificationInfo()}
   *   <li>{@link GeneralNotificationInfo#setData(Map)}
   *   <li>{@link GeneralNotificationInfo#toString()}
   *   <li>{@link GeneralNotificationInfo#getData()}
   *   <li>{@link GeneralNotificationInfo#getTemplateData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GeneralNotificationInfo.<init>()", "void GeneralNotificationInfo.<init>(Map)",
      "Map GeneralNotificationInfo.getData()", "Map GeneralNotificationInfo.getTemplateData()",
      "void GeneralNotificationInfo.setData(Map)", "String GeneralNotificationInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    GeneralNotificationInfo actualGeneralNotificationInfo = new GeneralNotificationInfo();
    HashMap<String, String> data = new HashMap<>();
    actualGeneralNotificationInfo.setData(data);
    String actualToStringResult = actualGeneralNotificationInfo.toString();
    Map<String, String> actualData = actualGeneralNotificationInfo.getData();
    Map<String, String> actualTemplateData = actualGeneralNotificationInfo.getTemplateData();

    // Assert
    assertEquals("GeneralNotificationInfo(data={})", actualToStringResult);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
    assertSame(data, actualTemplateData);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#GeneralNotificationInfo(Map)}
   *   <li>{@link GeneralNotificationInfo#setData(Map)}
   *   <li>{@link GeneralNotificationInfo#toString()}
   *   <li>{@link GeneralNotificationInfo#getData()}
   *   <li>{@link GeneralNotificationInfo#getTemplateData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GeneralNotificationInfo.<init>()", "void GeneralNotificationInfo.<init>(Map)",
      "Map GeneralNotificationInfo.getData()", "Map GeneralNotificationInfo.getTemplateData()",
      "void GeneralNotificationInfo.setData(Map)", "String GeneralNotificationInfo.toString()"})
  void testGettersAndSetters_whenHashMap() {
    // Arrange and Act
    GeneralNotificationInfo actualGeneralNotificationInfo = new GeneralNotificationInfo(new HashMap<>());
    HashMap<String, String> data = new HashMap<>();
    actualGeneralNotificationInfo.setData(data);
    String actualToStringResult = actualGeneralNotificationInfo.toString();
    Map<String, String> actualData = actualGeneralNotificationInfo.getData();
    Map<String, String> actualTemplateData = actualGeneralNotificationInfo.getTemplateData();

    // Assert
    assertEquals("GeneralNotificationInfo(data={})", actualToStringResult);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
    assertSame(data, actualTemplateData);
  }
}
