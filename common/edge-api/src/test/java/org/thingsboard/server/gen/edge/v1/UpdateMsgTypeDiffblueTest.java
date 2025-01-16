package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateMsgTypeDiffblueTest {
  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code ENTITY_MERGE_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'ENTITY_MERGE_RPC_MESSAGE'")
  void testForNumber_whenFive_thenReturnEntityMergeRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, UpdateMsgType.forNumber(5));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UpdateMsgType.forNumber(42));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code ALARM_CLEAR_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'ALARM_CLEAR_RPC_MESSAGE'")
  void testForNumber_whenFour_thenReturnAlarmClearRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, UpdateMsgType.forNumber(4));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ENTITY_UPDATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'ENTITY_UPDATED_RPC_MESSAGE'")
  void testForNumber_whenOne_thenReturnEntityUpdatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, UpdateMsgType.forNumber(1));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code ALARM_ACK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'ALARM_ACK_RPC_MESSAGE'")
  void testForNumber_whenThree_thenReturnAlarmAckRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, UpdateMsgType.forNumber(3));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code ENTITY_DELETED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'ENTITY_DELETED_RPC_MESSAGE'")
  void testForNumber_whenTwo_thenReturnEntityDeletedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, UpdateMsgType.forNumber(2));
  }

  /**
   * Test {@link UpdateMsgType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ENTITY_CREATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'ENTITY_CREATED_RPC_MESSAGE'")
  void testForNumber_whenZero_thenReturnEntityCreatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, UpdateMsgType.forNumber(0));
  }

  /**
   * Test {@link UpdateMsgType#getNumber()}.
   * <ul>
   *   <li>Given {@code ENTITY_CREATED_RPC_MESSAGE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'ENTITY_CREATED_RPC_MESSAGE'; then return zero")
  void testGetNumber_givenEntityCreatedRpcMessage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE.getNumber());
  }

  /**
   * Test {@link UpdateMsgType#getNumber()}.
   * <ul>
   *   <li>Given {@link UpdateMsgType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UpdateMsgType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link UpdateMsgType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link UpdateMsgType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> UpdateMsgType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is
   * {@code ENTITY_MERGE_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'ENTITY_MERGE_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsEntityMergeRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is
   * {@code ALARM_CLEAR_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'ALARM_CLEAR_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsAlarmClearRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is
   * {@code ENTITY_UPDATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'ENTITY_UPDATED_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsEntityUpdatedRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link AlarmUpdateMsg#STARTTS_FIELD_NUMBER}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber STARTTS_FIELD_NUMBER is 'null'")
  void testInternalGetValueMap_thenReturnFindValueByNumberStartts_field_numberIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is
   * {@code ALARM_ACK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'ALARM_ACK_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsAlarmAckRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is
   * {@code ENTITY_DELETED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'ENTITY_DELETED_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsEntityDeletedRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link UpdateMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is
   * {@code ENTITY_CREATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'ENTITY_CREATED_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsEntityCreatedRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code ENTITY_MERGE_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'ENTITY_MERGE_RPC_MESSAGE'")
  void testValueOfWithValue_whenFive_thenReturnEntityMergeRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, UpdateMsgType.valueOf(5));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UpdateMsgType.valueOf(42));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code ALARM_CLEAR_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'ALARM_CLEAR_RPC_MESSAGE'")
  void testValueOfWithValue_whenFour_thenReturnAlarmClearRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, UpdateMsgType.valueOf(4));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ENTITY_UPDATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'ENTITY_UPDATED_RPC_MESSAGE'")
  void testValueOfWithValue_whenOne_thenReturnEntityUpdatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, UpdateMsgType.valueOf(1));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code ALARM_ACK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'ALARM_ACK_RPC_MESSAGE'")
  void testValueOfWithValue_whenThree_thenReturnAlarmAckRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, UpdateMsgType.valueOf(3));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code ENTITY_DELETED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'ENTITY_DELETED_RPC_MESSAGE'")
  void testValueOfWithValue_whenTwo_thenReturnEntityDeletedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, UpdateMsgType.valueOf(2));
  }

  /**
   * Test {@link UpdateMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ENTITY_CREATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'ENTITY_CREATED_RPC_MESSAGE'")
  void testValueOfWithValue_whenZero_thenReturnEntityCreatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, UpdateMsgType.valueOf(0));
  }
}
