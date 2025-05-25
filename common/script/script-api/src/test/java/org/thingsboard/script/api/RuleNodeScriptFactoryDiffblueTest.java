package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleNodeScriptFactoryDiffblueTest {
  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   * <ul>
   *   <li>When {@code Arg Names}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when 'Arg Names'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"})
  void testGenerateRuleNodeScript_whenArgNames() {
    // Arrange, Act and Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msgType) {Not all who wander are lost\n" + "}\n" + "}",
        RuleNodeScriptFactory.generateRuleNodeScript("Function Name", "Not all who wander are lost", "Arg Names"));
  }

  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   * <ul>
   *   <li>When {@link RuleNodeScriptFactory#MSG} and {@link RuleNodeScriptFactory#METADATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when MSG and METADATA")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"})
  void testGenerateRuleNodeScript_whenMsgAndMetadata() {
    // Arrange, Act and Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msg) {Not all who wander are lost\n" + "}\n" + "}",
        RuleNodeScriptFactory.generateRuleNodeScript("Function Name", "Not all who wander are lost",
            RuleNodeScriptFactory.MSG, RuleNodeScriptFactory.METADATA, RuleNodeScriptFactory.MSG));
  }

  /**
   * Test {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeScriptFactory#generateRuleNodeScript(String, String, String[])}
   */
  @Test
  @DisplayName("Test generateRuleNodeScript(String, String, String[]); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeScriptFactory.generateRuleNodeScript(String, String, String[])"})
  void testGenerateRuleNodeScript_whenNull() {
    // Arrange, Act and Assert
    assertEquals(
        "function Function Name(msgStr, metadataStr, msgType) {     var msg = JSON.parse(msgStr);     var"
            + " metadata = JSON.parse(metadataStr);     return JSON.stringify(ruleNodeFunc(msg, metadata, msgType));"
            + "    function ruleNodeFunc(msg, metadata, msgType) {Not all who wander are lost\n" + "}\n" + "}",
        RuleNodeScriptFactory.generateRuleNodeScript("Function Name", "Not all who wander are lost", null));
  }
}
