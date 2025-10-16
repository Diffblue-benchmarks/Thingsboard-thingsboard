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
package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.elements.config.BasicDefinition;
import org.eclipse.californium.elements.config.Configuration;
import org.eclipse.californium.elements.config.TimeDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TbProperty;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;

class LwM2MNetworkConfigDiffblueTest {
  /**
   * Test {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}.
   *
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is {@code 42}.
   *   <li>Then calls {@link Configuration#add(Properties)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}
   */
  @Test
  @DisplayName(
      "Test getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig); given TbProperty (default constructor) Key is '42'; then calls add(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration LwM2MNetworkConfig.getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig)"
  })
  void testGetCoapConfig_givenTbPropertyKeyIs42_thenCallsAdd() {
    // Arrange
    Configuration coapConfig = mock(Configuration.class);
    doNothing().when(coapConfig).add(Mockito.<Properties>any());
    when(coapConfig.set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any()))
        .thenReturn(Configuration.createStandardWithoutFile());
    when(coapConfig.set(Mockito.<TimeDefinition>any(), anyInt(), Mockito.<TimeUnit>any()))
        .thenReturn(Configuration.createStandardWithoutFile());

    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("42");
    tbProperty2.setValue("Value");

    ArrayList<TbProperty> networkConfig = new ArrayList<>();
    networkConfig.add(tbProperty2);
    networkConfig.add(tbProperty);

    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    config.setNetworkConfig(networkConfig);

    // Act
    LwM2MNetworkConfig.getCoapConfig(coapConfig, 1, 8080, config);

    // Assert
    verify(coapConfig).add(isA(Properties.class));
    verify(coapConfig, atLeast(1))
        .set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any());
    verify(coapConfig).set(isA(TimeDefinition.class), eq(300), eq(TimeUnit.SECONDS));
  }

  /**
   * Test {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}.
   *
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is {@code Key}.
   *   <li>Then calls {@link Configuration#add(Properties)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}
   */
  @Test
  @DisplayName(
      "Test getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig); given TbProperty (default constructor) Key is 'Key'; then calls add(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration LwM2MNetworkConfig.getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig)"
  })
  void testGetCoapConfig_givenTbPropertyKeyIsKey_thenCallsAdd() {
    // Arrange
    Configuration coapConfig = mock(Configuration.class);
    doNothing().when(coapConfig).add(Mockito.<Properties>any());
    when(coapConfig.set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any()))
        .thenReturn(Configuration.createStandardWithoutFile());
    when(coapConfig.set(Mockito.<TimeDefinition>any(), anyInt(), Mockito.<TimeUnit>any()))
        .thenReturn(Configuration.createStandardWithoutFile());

    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    ArrayList<TbProperty> networkConfig = new ArrayList<>();
    networkConfig.add(tbProperty);

    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    config.setNetworkConfig(networkConfig);

    // Act
    LwM2MNetworkConfig.getCoapConfig(coapConfig, 1, 8080, config);

    // Assert
    verify(coapConfig).add(isA(Properties.class));
    verify(coapConfig, atLeast(1))
        .set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any());
    verify(coapConfig).set(isA(TimeDefinition.class), eq(300), eq(TimeUnit.SECONDS));
  }

  /**
   * Test {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}.
   *
   * <ul>
   *   <li>When {@link LwM2MTransportServerConfig} (default constructor).
   *   <li>Then calls {@link Configuration#set(BasicDefinition, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MNetworkConfig#getCoapConfig(Configuration, Integer, Integer,
   * LwM2MTransportServerConfig)}
   */
  @Test
  @DisplayName(
      "Test getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig); when LwM2MTransportServerConfig (default constructor); then calls set(BasicDefinition, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration LwM2MNetworkConfig.getCoapConfig(Configuration, Integer, Integer, LwM2MTransportServerConfig)"
  })
  void testGetCoapConfig_whenLwM2MTransportServerConfig_thenCallsSet() {
    // Arrange
    Configuration coapConfig = mock(Configuration.class);
    when(coapConfig.set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any()))
        .thenReturn(Configuration.createStandardWithoutFile());
    when(coapConfig.set(Mockito.<TimeDefinition>any(), anyInt(), Mockito.<TimeUnit>any()))
        .thenReturn(Configuration.createStandardWithoutFile());

    // Act
    LwM2MNetworkConfig.getCoapConfig(coapConfig, 1, 8080, new LwM2MTransportServerConfig());

    // Assert
    verify(coapConfig, atLeast(1))
        .set(Mockito.<BasicDefinition<Object>>any(), Mockito.<Object>any());
    verify(coapConfig).set(isA(TimeDefinition.class), eq(300), eq(TimeUnit.SECONDS));
  }
}
