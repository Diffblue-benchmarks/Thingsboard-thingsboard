/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
