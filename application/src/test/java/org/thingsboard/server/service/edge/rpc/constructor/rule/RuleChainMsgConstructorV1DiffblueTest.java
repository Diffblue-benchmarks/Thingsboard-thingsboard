package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMsgConstructorV1DiffblueTest {
  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType =
        actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setFirstRuleNodeId(
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    assertEquals(
        -7476899250389416711L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdLSB());
    assertEquals(56, actualConstructRuleChainUpdatedMsgResult.getSerializedSize());
    assertEquals(7, actualConstructRuleChainUpdatedMsgResult.getAllFields().size());
    assertEquals(
        8669210807411032922L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdMSB());
    assertTrue(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdLSB());
    assertTrue(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdMSB());
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); given empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg_givenEmptyArrayOfByte() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {});
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType =
        actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); when RuleChain(RuleChain) with ruleChain is RuleChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg_whenRuleChainWithRuleChainIsRuleChain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType =
        actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
