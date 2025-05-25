package org.thingsboard.server.transport.lwm2m.server.rpc.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcReadCompositeRequestDiffblueTest {
  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}, and {@link RpcReadCompositeRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
    int expectedHashCodeResult = rpcReadCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcReadCompositeRequest2.hashCode());
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}, and {@link RpcReadCompositeRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest);
    int expectedHashCodeResult = rpcReadCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcReadCompositeRequest.hashCode());
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest
        .setIds(new String[]{"org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcReadCompositeRequest"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest
        .setKeys(new String[]{"org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcReadCompositeRequest"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, null);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcReadCompositeRequest.equals(Object)", "int RpcReadCompositeRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, "Different type to RpcReadCompositeRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcReadCompositeRequest}
   *   <li>{@link RpcReadCompositeRequest#setIds(String[])}
   *   <li>{@link RpcReadCompositeRequest#setKeys(String[])}
   *   <li>{@link RpcReadCompositeRequest#toString()}
   *   <li>{@link RpcReadCompositeRequest#getIds()}
   *   <li>{@link RpcReadCompositeRequest#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RpcReadCompositeRequest.<init>()", "String[] RpcReadCompositeRequest.getIds()",
      "String[] RpcReadCompositeRequest.getKeys()", "void RpcReadCompositeRequest.setIds(String[])",
      "void RpcReadCompositeRequest.setKeys(String[])", "String RpcReadCompositeRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RpcReadCompositeRequest actualRpcReadCompositeRequest = new RpcReadCompositeRequest();
    String[] ids = new String[]{"Ids"};
    actualRpcReadCompositeRequest.setIds(ids);
    String[] keys = new String[]{"Keys"};
    actualRpcReadCompositeRequest.setKeys(keys);
    String actualToStringResult = actualRpcReadCompositeRequest.toString();
    String[] actualIds = actualRpcReadCompositeRequest.getIds();
    String[] actualKeys = actualRpcReadCompositeRequest.getKeys();

    // Assert
    assertEquals("RpcReadCompositeRequest(keys=[Keys], ids=[Ids])", actualToStringResult);
    assertSame(ids, actualIds);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[]{"Ids"}, actualIds);
    assertArrayEquals(new String[]{"Keys"}, actualKeys);
  }
}
