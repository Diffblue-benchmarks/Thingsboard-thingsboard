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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TimePageLink;

class AlarmStatusFilterDiffblueTest {
  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new ArrayList<>());

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom2() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from((Collection<AlarmSearchStatus>) null);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom3() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ANY);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom4() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);
    statuses.add(AlarmSearchStatus.ANY);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom5() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(null);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom6() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom7() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.CLEARED);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom8() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom9() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.UNACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom10() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);
    statuses.add(AlarmSearchStatus.CLEARED);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  void testFrom11() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.UNACK);
    statuses.add(AlarmSearchStatus.ACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom12() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom13() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom14() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom15() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.CLEARED, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom16() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom17() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.UNACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom18() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, null, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom19() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.ACTIVE_ACK, null, true));

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom20() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.CLEARED_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  void testFrom21() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.CLEARED_ACK, null, true));

    // Assert
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  void testFrom22() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ANY);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  void testFrom23() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ACK);

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  void testFrom24() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  void testFrom25() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ACTIVE);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  void testFrom26() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.CLEARED);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  void testFrom27() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  void testFrom28() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  void testFrom29() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  void testFrom30() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_ACK);

    // Assert
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  void testMatches() {
    // Arrange
    AlarmStatusFilter emptyResult = AlarmStatusFilter.empty();

    // Act and Assert
    assertTrue(emptyResult.matches(new Alarm()));
  }

  /**
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  void testMatches2() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    // Act and Assert
    assertTrue(fromResult.matches(new Alarm()));
  }

  /**
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  void testMatches3() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK);

    // Act and Assert
    assertFalse(fromResult.matches(new Alarm()));
  }

  /**
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  void testMatches4() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK);

    // Act and Assert
    assertFalse(fromResult.matches(new Alarm()));
  }

  /**
   * Method under test: {@link AlarmStatusFilter#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange and Act
    AlarmStatusFilter actualEmptyResult = AlarmStatusFilter.empty();

    // Assert
    assertFalse(actualEmptyResult.hasAckFilter());
    assertFalse(actualEmptyResult.hasAnyFilter());
    assertFalse(actualEmptyResult.hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  void testHasAnyFilter() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAnyFilter());
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAnyFilter());
    assertTrue(AlarmStatusFilter.from(AlarmSearchStatus.ACK).hasAnyFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#hasClearFilter()}
   */
  @Test
  void testHasClearFilter() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasClearFilter());
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#hasAckFilter()}
   */
  @Test
  void testHasAckFilter() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAckFilter());
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAckFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  void testGetClearFilter() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getClearFilter());
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getClearFilter());
    assertTrue(AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK).getClearFilter());
  }

  /**
   * Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  void testGetAckFilter() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getAckFilter());
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getAckFilter());
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK).getAckFilter());
  }
}
