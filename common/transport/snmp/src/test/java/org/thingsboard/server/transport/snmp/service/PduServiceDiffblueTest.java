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
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'")
  void testProcessPdusWithPdusResponseMappings() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>Given {@link PDU#PDU()} add
   * {@link VariableBinding#VariableBinding()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU() add VariableBinding()")
  void testProcessPdusWithPdusResponseMappings_givenPduAddVariableBinding() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>Given {@link PDU#PDU()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>Given {@link PDU#PDU()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu2() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>Then calls {@link PDU#add(VariableBinding)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls add(VariableBinding)")
  void testProcessPdusWithPdusResponseMappings_thenCallsAdd() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>Then calls {@link VariableBinding#getOid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls getOid()")
  void testProcessPdusWithPdusResponseMappings_thenCallsGetOid() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; when ArrayList(); then return size is zero")
  void testProcessPdusWithPdusResponseMappings_whenArrayList_thenReturnSizeIsZero() {
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
   * Test {@link PduService#processPdus(List, List)} with {@code pdus},
   * {@code responseMappings}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; when 'null'; then return size is zero")
  void testProcessPdusWithPdusResponseMappings_whenNull_thenReturnSizeIsZero() {
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
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>Given {@link PDU#PDU()} add
   * {@link VariableBinding#VariableBinding()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; given PDU() add VariableBinding(); when ArrayList() add PDU()")
  void testProcessPdusWithPdus_givenPduAddVariableBinding_whenArrayListAddPdu() {
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
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>Given {@link PDU} {@link PDU#getVariableBindings()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PDU#add(VariableBinding)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; given PDU getVariableBindings() return ArrayList(); then calls add(VariableBinding)")
  void testProcessPdusWithPdus_givenPduGetVariableBindingsReturnArrayList_thenCallsAdd() {
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
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>Given {@link PDU#PDU()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>Given {@link PDU#PDU()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty2() {
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
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; then return size is one")
  void testProcessPdusWithPdus_thenReturnSizeIsOne() {
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
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; when ArrayList(); then return Empty")
  void testProcessPdusWithPdus_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertTrue(pduService.processPdus(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is three")
  void testProcessValue_given42_thenJsonObjectSizeIsThree() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is three")
  void testProcessValue_given42_thenJsonObjectSizeIsThree2() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is two")
  void testProcessValue_given42_thenJsonObjectSizeIsTwo() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; when '.'; then JsonObject (default constructor) size is three")
  void testProcessValue_given42_whenDot_thenJsonObjectSizeIsThree() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; when '.'; then JsonObject (default constructor) size is three")
  void testProcessValue_given42_whenDot_thenJsonObjectSizeIsThree2() {
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

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Boolean#FALSE} toString.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '42'; when FALSE toString; then JsonObject (default constructor) size is three")
  void testProcessValue_given42_whenFalseToString_thenJsonObjectSizeIsThree() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link JsonObject} (default constructor) add {@code .} and
   * {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given '.'; when JsonObject (default constructor) add '.' and JsonArray(int) with capacity is three")
  void testProcessValue_givenDot_whenJsonObjectAddDotAndJsonArrayWithCapacityIsThree() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Given {@link JsonElement}.</li>
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and
   * {@link JsonElement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); given JsonElement; when JsonObject (default constructor) add 'Property' and JsonElement")
  void testProcessValue_givenJsonElement_whenJsonObjectAddPropertyAndJsonElement() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>Then {@link JsonObject} (default constructor) size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); then JsonObject (default constructor) size is two")
  void testProcessValue_thenJsonObjectSizeIsTwo() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when 'BOOLEAN'; then throw IllegalArgumentException")
  void testProcessValue_whenBoolean_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pduService.processValue("Key", DataType.BOOLEAN, "42", new JsonObject()));
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then {@link JsonObject} (default constructor) size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when JsonObject (default constructor); then JsonObject (default constructor) size is one")
  void testProcessValue_whenJsonObject_thenJsonObjectSizeIsOne() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when 'STRING'; then JsonObject (default constructor) size is one")
  void testProcessValue_whenString_thenJsonObjectSizeIsOne() {
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
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then {@link JsonObject} (default constructor) size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName("Test processValue(String, DataType, String, JsonObject); when TRUE toString; then JsonObject (default constructor) size is one")
  void testProcessValue_whenTrueToString_thenJsonObjectSizeIsOne() {
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
}
