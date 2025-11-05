package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleNodeScriptFactoryDiffblueTest {
  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Arg Names}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String,
   * String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when 'Arg Names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"
  })
  void testGenerateRuleNodeScript_whenArgNames() {
    // Arrange and Act
    String actualGenerateRuleNodeScriptResult =
        RuleNodeScriptFactory.generateRuleNodeScript(
            "Function Name", "Not all who wander are lost", "Arg Names");

    // Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msgType) {Not all who wander are lost\n"
            + "}\n"
            + "}",
        actualGenerateRuleNodeScriptResult);
  }

  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@link RuleNodeScriptFactory#MSG} and {@link RuleNodeScriptFactory#METADATA}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String,
   * String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when MSG and METADATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"
  })
  void testGenerateRuleNodeScript_whenMsgAndMetadata() {
    // Arrange and Act
    String actualGenerateRuleNodeScriptResult =
        RuleNodeScriptFactory.generateRuleNodeScript(
            "Function Name",
            "Not all who wander are lost",
            RuleNodeScriptFactory.MSG,
            RuleNodeScriptFactory.METADATA,
            RuleNodeScriptFactory.MSG);

    // Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msg) {Not all who wander are lost\n"
            + "}\n"
            + "}",
        actualGenerateRuleNodeScriptResult);
  }

  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String,
   * String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"
  })
  void testGenerateRuleNodeScript_whenNull() {
    // Arrange and Act
    String actualGenerateRuleNodeScriptResult =
        RuleNodeScriptFactory.generateRuleNodeScript(
            "Function Name", "Not all who wander are lost", null);

    // Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msgType) {Not all who wander are lost\n"
            + "}\n"
            + "}",
        actualGenerateRuleNodeScriptResult);
  }
}
