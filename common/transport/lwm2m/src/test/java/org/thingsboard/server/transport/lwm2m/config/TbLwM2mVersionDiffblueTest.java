package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbLwM2mVersionDiffblueTest {
  /**
   * Test {@link TbLwM2mVersion#fromCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code VERSION_1_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromCode(int)}
   */
  @Test
  @DisplayName("Test fromCode(int); when one; then return 'VERSION_1_1'")
  void testFromCode_whenOne_thenReturnVersion11() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromCode(1));
  }

  /**
   * Test {@link TbLwM2mVersion#fromCode(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromCode(int)}
   */
  @Test
  @DisplayName("Test fromCode(int); when two; then throw IllegalArgumentException")
  void testFromCode_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromCode(2));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersionStr(String)}.
   * <ul>
   *   <li>When {@code 1.0}.</li>
   *   <li>Then return {@code VERSION_1_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromVersionStr(String)}
   */
  @Test
  @DisplayName("Test fromVersionStr(String); when '1.0'; then return 'VERSION_1_0'")
  void testFromVersionStr_when10_thenReturnVersion10() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersionStr("1.0"));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersionStr(String)}.
   * <ul>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromVersionStr(String)}
   */
  @Test
  @DisplayName("Test fromVersionStr(String); when '1.0.2'; then throw IllegalArgumentException")
  void testFromVersionStr_when102_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersionStr("1.0.2"));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   * <ul>
   *   <li>When Default.</li>
   *   <li>Then return {@code VERSION_1_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromVersion(LwM2m.LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when Default; then return 'VERSION_1_0'")
  void testFromVersion_whenDefault_thenReturnVersion10() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersion(LwM2m.LwM2mVersion.getDefault()));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   * <ul>
   *   <li>When lastSupported.</li>
   *   <li>Then return {@code VERSION_1_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromVersion(LwM2m.LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when lastSupported; then return 'VERSION_1_1'")
  void testFromVersion_whenLastSupported_thenReturnVersion11() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromVersion(LwM2m.LwM2mVersion.lastSupported()));
  }

  /**
   * Test {@link TbLwM2mVersion#fromVersion(LwM2mVersion)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mVersion#fromVersion(LwM2m.LwM2mVersion)}
   */
  @Test
  @DisplayName("Test fromVersion(LwM2mVersion); when 'null'; then throw IllegalArgumentException")
  void testFromVersion_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersion(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2mVersion#getCode()}
   *   <li>{@link TbLwM2mVersion#getContentFormat()}
   *   <li>{@link TbLwM2mVersion#getVersion()}
   *   <li>{@link TbLwM2mVersion#isComposite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2mVersion valueOfResult = TbLwM2mVersion.valueOf("VERSION_1_0");

    // Act
    int actualCode = valueOfResult.getCode();
    ContentFormat actualContentFormat = valueOfResult.getContentFormat();
    LwM2m.LwM2mVersion actualVersion = valueOfResult.getVersion();

    // Assert
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isComposite());
    assertTrue(actualVersion.isSupported());
    assertSame(actualContentFormat.TLV, actualContentFormat);
  }
}
