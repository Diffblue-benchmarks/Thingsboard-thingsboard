package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class UpdateMsgTypeDiffblueTest {
  /**
   * Method under test: {@link UpdateMsgType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(UpdateMsgType.forNumber(42));
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, UpdateMsgType.forNumber(0));
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, UpdateMsgType.forNumber(1));
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, UpdateMsgType.forNumber(2));
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, UpdateMsgType.forNumber(3));
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, UpdateMsgType.forNumber(4));
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, UpdateMsgType.forNumber(5));
  }

  /**
   * Method under test: {@link UpdateMsgType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE.getNumber());
    assertThrows(IllegalArgumentException.class, () -> UpdateMsgType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link UpdateMsgType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> UpdateMsgType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link UpdateMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<UpdateMsgType> actualInternalGetValueMapResult = UpdateMsgType.internalGetValueMap();

    // Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link UpdateMsgType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(UpdateMsgType.valueOf(42));
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, UpdateMsgType.valueOf(0));
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, UpdateMsgType.valueOf(1));
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, UpdateMsgType.valueOf(2));
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE, UpdateMsgType.valueOf(3));
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE, UpdateMsgType.valueOf(4));
    assertEquals(UpdateMsgType.ENTITY_MERGE_RPC_MESSAGE, UpdateMsgType.valueOf(5));
  }
}
