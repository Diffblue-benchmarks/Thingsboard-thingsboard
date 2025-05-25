package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.api.AuthProvider;
import com.google.protobuf.GeneratedMessageV3;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}, and {@link TbProtoQueueMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProtoQueueMsg#equals(Object)}
   *   <li>{@link TbProtoQueueMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertEquals(tbProtoQueueMsg, tbProtoQueueMsg);
    int expectedHashCodeResult = tbProtoQueueMsg.hashCode();
    assertEquals(expectedHashCodeResult, tbProtoQueueMsg.hashCode());
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    UUID key2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key2, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    UUID key2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key2, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(null, Advice.getDefaultInstance());
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null);
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, AuthProvider.getDefaultInstance());
    UUID key2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, new TbProtoQueueMsg<>(key2, Advice.getDefaultInstance()));
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = mock(TbProtoJsQueueMsg.class);
    when(tbProtoJsQueueMsg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    when(tbProtoJsQueueMsg.getValue()).thenReturn(Advice.getDefaultInstance());
    when(tbProtoJsQueueMsg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tbProtoJsQueueMsg.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, tbProtoJsQueueMsg);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, null);
  }

  /**
   * Test {@link TbProtoQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProtoQueueMsg.equals(Object)", "int TbProtoQueueMsg.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertNotEquals(tbProtoQueueMsg, "Different type to TbProtoQueueMsg");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}
   *   <li>{@link TbProtoQueueMsg#toString()}
   *   <li>{@link TbProtoQueueMsg#getHeaders()}
   *   <li>{@link TbProtoQueueMsg#getKey()}
   *   <li>{@link TbProtoQueueMsg#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3, TbQueueMsgHeaders)",
      "TbQueueMsgHeaders TbProtoQueueMsg.getHeaders()", "UUID TbProtoQueueMsg.getKey()",
      "GeneratedMessageV3 TbProtoQueueMsg.getValue()", "java.lang.String TbProtoQueueMsg.toString()"})
  void testGettersAndSetters() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();
    DefaultTbQueueMsgHeaders headers = new DefaultTbQueueMsgHeaders();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg = new TbProtoQueueMsg<>(key, defaultInstance, headers);
    actualTbProtoQueueMsg.toString();
    TbQueueMsgHeaders actualHeaders = actualTbProtoQueueMsg.getHeaders();
    UUID actualKey = actualTbProtoQueueMsg.getKey();
    GeneratedMessageV3 actualValue = actualTbProtoQueueMsg.getValue();

    // Assert
    assertTrue(actualHeaders instanceof DefaultTbQueueMsgHeaders);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualKey.toString());
    assertSame(headers, actualHeaders);
    assertSame(defaultInstance, actualValue);
    assertSame(key, actualKey);
  }

  /**
   * Test {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}.
   * <p>
   * Method under test: {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoQueueMsg() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg = new TbProtoQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoQueueMsg.getValue());
    assertSame(key, actualTbProtoQueueMsg.getKey());
    assertArrayEquals(new byte[]{}, actualTbProtoQueueMsg.getData());
  }

  /**
   * Test {@link TbProtoQueueMsg#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoQueueMsg.getData()"})
  void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoQueueMsg<GeneratedMessageV3> tbProtoQueueMsg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{}, tbProtoQueueMsg.getData());
  }
}
