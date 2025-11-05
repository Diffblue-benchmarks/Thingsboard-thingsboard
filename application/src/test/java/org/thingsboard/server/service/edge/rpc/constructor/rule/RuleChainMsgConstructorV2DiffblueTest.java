package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMsgConstructorV2DiffblueTest {
  /**
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();
    RuleChainId id = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new RuleChain(id), true);

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
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setConfigurationBytes(new byte[] {});

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
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
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
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
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setConfigurationBytes(new byte[] {});

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
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
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChain.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
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
