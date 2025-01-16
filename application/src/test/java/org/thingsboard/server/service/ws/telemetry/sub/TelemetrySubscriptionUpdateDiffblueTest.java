package org.thingsboard.server.service.ws.telemetry.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.service.subscription.SubscriptionErrorCode;

@DisabledInAotMode
class TelemetrySubscriptionUpdateDiffblueTest {
  @MockBean
  private TelemetrySubscriptionUpdate telemetrySubscriptionUpdate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, Map)}
   *   <li>{@link TelemetrySubscriptionUpdate#toString()}
   *   <li>{@link TelemetrySubscriptionUpdate#getData()}
   *   <li>{@link TelemetrySubscriptionUpdate#getErrorCode()}
   *   <li>{@link TelemetrySubscriptionUpdate#getErrorMsg()}
   *   <li>{@link TelemetrySubscriptionUpdate#getSubscriptionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, List<Object>> data = new HashMap<>();

    // Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1, data);
    String actualToStringResult = actualTelemetrySubscriptionUpdate.toString();
    Map<String, List<Object>> actualData = actualTelemetrySubscriptionUpdate.getData();
    int actualErrorCode = actualTelemetrySubscriptionUpdate.getErrorCode();
    String actualErrorMsg = actualTelemetrySubscriptionUpdate.getErrorMsg();

    // Assert
    assertEquals("TelemetrySubscriptionUpdate [subscriptionId=1, errorCode=0, errorMsg=null, data=",
        actualToStringResult);
    assertNull(actualErrorMsg);
    assertEquals(0, actualErrorCode);
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return ErrorMsg is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, int, String, Map)}
   *   <li>{@link TelemetrySubscriptionUpdate#toString()}
   *   <li>{@link TelemetrySubscriptionUpdate#getData()}
   *   <li>{@link TelemetrySubscriptionUpdate#getErrorCode()}
   *   <li>{@link TelemetrySubscriptionUpdate#getErrorMsg()}
   *   <li>{@link TelemetrySubscriptionUpdate#getSubscriptionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when minus one; then return ErrorMsg is 'An error occurred'")
  void testGettersAndSetters_whenMinusOne_thenReturnErrorMsgIsAnErrorOccurred() {
    // Arrange
    HashMap<String, List<Object>> data = new HashMap<>();

    // Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1, -1,
        "An error occurred", data);
    String actualToStringResult = actualTelemetrySubscriptionUpdate.toString();
    Map<String, List<Object>> actualData = actualTelemetrySubscriptionUpdate.getData();
    int actualErrorCode = actualTelemetrySubscriptionUpdate.getErrorCode();
    String actualErrorMsg = actualTelemetrySubscriptionUpdate.getErrorMsg();

    // Assert
    assertEquals("An error occurred", actualErrorMsg);
    assertEquals("TelemetrySubscriptionUpdate [subscriptionId=1, errorCode=-1, errorMsg=An error occurred, data=",
        actualToStringResult);
    assertEquals(-1, actualErrorCode);
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }

  /**
   * Test
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String)}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String)}
   */
  @Test
  @DisplayName("Test new TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String); then return ErrorMsg is 'An error occurred'")
  void testNewTelemetrySubscriptionUpdate_thenReturnErrorMsgIsAnErrorOccurred() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1,
        SubscriptionErrorCode.NO_ERROR, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualTelemetrySubscriptionUpdate.getErrorMsg());
    assertNull(actualTelemetrySubscriptionUpdate.getData());
    assertEquals(0, actualTelemetrySubscriptionUpdate.getErrorCode());
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualTelemetrySubscriptionUpdate.getLatestValues().isEmpty());
  }

  /**
   * Test
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, List)}
   */
  @Test
  @DisplayName("Test new TelemetrySubscriptionUpdate(int, List); when ArrayList(); then return ErrorMsg is 'null'")
  void testNewTelemetrySubscriptionUpdate_whenArrayList_thenReturnErrorMsgIsNull() {
    // Arrange and Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1,
        new ArrayList<>());

    // Assert
    assertNull(actualTelemetrySubscriptionUpdate.getErrorMsg());
    assertEquals(0, actualTelemetrySubscriptionUpdate.getErrorCode());
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualTelemetrySubscriptionUpdate.getData().isEmpty());
    assertTrue(actualTelemetrySubscriptionUpdate.getLatestValues().isEmpty());
  }

  /**
   * Test
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode)}.
   * <ul>
   *   <li>When {@code NO_ERROR}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode)}
   */
  @Test
  @DisplayName("Test new TelemetrySubscriptionUpdate(int, SubscriptionErrorCode); when 'NO_ERROR'; then return ErrorMsg is 'null'")
  void testNewTelemetrySubscriptionUpdate_whenNoError_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1,
        SubscriptionErrorCode.NO_ERROR);

    // Assert
    assertNull(actualTelemetrySubscriptionUpdate.getErrorMsg());
    assertNull(actualTelemetrySubscriptionUpdate.getData());
    assertEquals(0, actualTelemetrySubscriptionUpdate.getErrorCode());
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualTelemetrySubscriptionUpdate.getLatestValues().isEmpty());
  }

  /**
   * Test
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String)}.
   * <ul>
   *   <li>When {@code NO_ERROR}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetrySubscriptionUpdate#TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String)}
   */
  @Test
  @DisplayName("Test new TelemetrySubscriptionUpdate(int, SubscriptionErrorCode, String); when 'NO_ERROR'; then return ErrorMsg is 'null'")
  void testNewTelemetrySubscriptionUpdate_whenNoError_thenReturnErrorMsgIsNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TelemetrySubscriptionUpdate actualTelemetrySubscriptionUpdate = new TelemetrySubscriptionUpdate(1,
        SubscriptionErrorCode.NO_ERROR, null);

    // Assert
    assertNull(actualTelemetrySubscriptionUpdate.getErrorMsg());
    assertNull(actualTelemetrySubscriptionUpdate.getData());
    assertEquals(0, actualTelemetrySubscriptionUpdate.getErrorCode());
    assertEquals(1, actualTelemetrySubscriptionUpdate.getSubscriptionId());
    assertTrue(actualTelemetrySubscriptionUpdate.getLatestValues().isEmpty());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#getLatestValues()}.
   * <p>
   * Method under test: {@link TelemetrySubscriptionUpdate#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues()")
  void testGetLatestValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TelemetrySubscriptionUpdate(1, SubscriptionErrorCode.NO_ERROR)).getLatestValues().isEmpty());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#getLatestValues()}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetrySubscriptionUpdate#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return size is one")
  void testGetLatestValues_givenJsonDataEntryWithKeyAndValueIs42_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    Map<String, Long> actualLatestValues = (new TelemetrySubscriptionUpdate(1, data)).getLatestValues();

    // Assert
    assertEquals(1, actualLatestValues.size());
    assertEquals(1L, actualLatestValues.get("Key").longValue());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#getLatestValues()}.
   * <ul>
   *   <li>Given {@link KvEntry} {@link KvEntry#getValueAsString()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetrySubscriptionUpdate#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); given KvEntry getValueAsString() return '42'; then calls getKey()")
  void testGetLatestValues_givenKvEntryGetValueAsStringReturn42_thenCallsGetKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    KvEntry kv = mock(KvEntry.class);
    when(kv.getValueAsString()).thenReturn("42");
    when(kv.getKey()).thenReturn("Key");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(basicTsKvEntry);

    // Act
    Map<String, Long> actualLatestValues = (new TelemetrySubscriptionUpdate(1, data)).getLatestValues();

    // Assert
    verify(kv).getKey();
    verify(kv).getValueAsString();
    assertEquals(1, actualLatestValues.size());
    assertEquals(1L, actualLatestValues.get("Key").longValue());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#getLatestValues()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetrySubscriptionUpdate#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); then return Empty")
  void testGetLatestValues_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TelemetrySubscriptionUpdate(1, new ArrayList<>())).getLatestValues().isEmpty());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#getLatestValues()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetrySubscriptionUpdate#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues(); then return size is two")
  void testGetLatestValues_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("42", "42")));
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    Map<String, Long> actualLatestValues = (new TelemetrySubscriptionUpdate(1, data)).getLatestValues();

    // Assert
    assertEquals(2, actualLatestValues.size());
    assertEquals(1L, actualLatestValues.get("42").longValue());
    assertEquals(1L, actualLatestValues.get("Key").longValue());
  }

  /**
   * Test {@link TelemetrySubscriptionUpdate#copyWithNewSubscriptionId(int)}.
   * <p>
   * Method under test:
   * {@link TelemetrySubscriptionUpdate#copyWithNewSubscriptionId(int)}
   */
  @Test
  @DisplayName("Test copyWithNewSubscriptionId(int)")
  void testCopyWithNewSubscriptionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TelemetrySubscriptionUpdate actualCopyWithNewSubscriptionIdResult = (new TelemetrySubscriptionUpdate(1,
        SubscriptionErrorCode.NO_ERROR)).copyWithNewSubscriptionId(1);

    // Assert
    assertNull(actualCopyWithNewSubscriptionIdResult.getErrorMsg());
    assertNull(actualCopyWithNewSubscriptionIdResult.getData());
    assertEquals(0, actualCopyWithNewSubscriptionIdResult.getErrorCode());
    assertEquals(1, actualCopyWithNewSubscriptionIdResult.getSubscriptionId());
    assertTrue(actualCopyWithNewSubscriptionIdResult.getLatestValues().isEmpty());
  }
}
