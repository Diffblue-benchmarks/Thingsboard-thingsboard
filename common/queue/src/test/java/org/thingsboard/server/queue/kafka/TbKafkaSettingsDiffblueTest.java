package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TbProperty;

class TbKafkaSettingsDiffblueTest {
  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <ul>
   *   <li>Given {@link TbKafkaSettings} (default constructor) Other is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); given TbKafkaSettings (default constructor) Other is ArrayList(); then return size is one")
  void testToProps_givenTbKafkaSettingsOtherIsArrayList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(new ArrayList<>());

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <ul>
   *   <li>Given {@link TbKafkaSettings} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); given TbKafkaSettings (default constructor); then return size is one")
  void testToProps_givenTbKafkaSettings_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Properties actualToPropsResult = (new TbKafkaSettings()).toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <ul>
   *   <li>Given {@link TbProperty} {@link TbProperty#getKey()} return
   * {@code Key}.</li>
   *   <li>Then return {@code Key} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); given TbProperty getKey() return 'Key'; then return 'Key' is '42'")
  void testToProps_givenTbPropertyGetKeyReturnKey_thenReturnKeyIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = mock(TbProperty.class);
    when(tbProperty.getKey()).thenReturn("Key");
    when(tbProperty.getValue()).thenReturn("42");
    doNothing().when(tbProperty).setKey(Mockito.<String>any());
    doNothing().when(tbProperty).setValue(Mockito.<String>any());
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    verify(tbProperty).getKey();
    verify(tbProperty).getValue();
    verify(tbProperty).setKey(eq("request.timeout.ms"));
    verify(tbProperty).setValue(eq("42"));
    assertEquals(2, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("Key"));
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is {@code Key}.</li>
   *   <li>Then return {@code Key} is {@code request.timeout.ms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); given TbProperty (default constructor) Key is 'Key'; then return 'Key' is 'request.timeout.ms'")
  void testToProps_givenTbPropertyKeyIsKey_thenReturnKeyIsRequestTimeoutMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("request.timeout.ms");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty2);
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(2, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("request.timeout.ms"));
    assertEquals("request.timeout.ms", actualToPropsResult.get("Key"));
  }

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is
   * {@code request.timeout.ms}.</li>
   *   <li>Then return {@code request.timeout.ms} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); given TbProperty (default constructor) Key is 'request.timeout.ms'; then return 'request.timeout.ms' is '42'")
  void testToProps_givenTbPropertyKeyIsRequestTimeoutMs_thenReturnRequestTimeoutMsIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("request.timeout.ms"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbKafkaSettings#setConsumerPropertiesPerTopic(Map)}
   *   <li>{@link TbKafkaSettings#setOther(List)}
   *   <li>{@link TbKafkaSettings#getReplicationFactor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();

    // Act
    tbKafkaSettings.setConsumerPropertiesPerTopic(new HashMap<>());
    tbKafkaSettings.setOther(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals((short) 0, tbKafkaSettings.getReplicationFactor());
  }
}
