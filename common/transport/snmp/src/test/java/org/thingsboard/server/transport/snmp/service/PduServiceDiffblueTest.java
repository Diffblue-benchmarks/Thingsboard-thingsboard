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
package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.snmp4j.PDU;
import org.snmp4j.agent.mo.snmp.RowCount;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;

class PduServiceDiffblueTest {
  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertTrue(pduService.processPdus(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings()).thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertTrue(actualProcessPdusResult.isEmpty());
  }

  /**
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  void testProcessPdus6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings()).thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(1, actualProcessPdusResult.size());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(new ArrayList<>(), null);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings()).thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings()).thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  void testProcessPdus14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    ArrayList<SnmpMapping> responseMappings = new ArrayList<>();
    responseMappings.add(new SnmpMapping("42", "Key", DataType.BOOLEAN));

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, responseMappings);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pduService.processValue("Key", DataType.BOOLEAN, "42", new JsonObject()));
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.STRING, "42", result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    String value = Boolean.TRUE.toString();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.BOOLEAN, value, result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add(".", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", mock(JsonElement.class));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(".", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();
    String key = Boolean.FALSE.toString();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(key, DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("42", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  void testProcessValue13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(".", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }
}
