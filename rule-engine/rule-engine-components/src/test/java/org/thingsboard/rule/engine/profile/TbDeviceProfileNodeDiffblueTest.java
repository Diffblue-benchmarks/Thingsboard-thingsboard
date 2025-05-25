package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.rule.RuleNodeState;

class TbDeviceProfileNodeDiffblueTest {
  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("{}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowIllegalArgumentException2() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("{}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)}
   */
  @Test
  @DisplayName("Test getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.rule.engine.profile.DeviceState TbDeviceProfileNode.getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)"})
  void testGetOrCreateDeviceState_thenThrowIllegalArgumentException() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbDeviceProfileNode.getOrCreateDeviceState(ctx, deviceId, new RuleNodeState(), true));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test updateProfile(TbContext, DeviceProfileId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeviceProfileNode.updateProfile(TbContext, DeviceProfileId)"})
  void testUpdateProfile_thenThrowIllegalArgumentException() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.updateProfile(ctx, null));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(1, oldConfiguration).getSecond());
  }
}
