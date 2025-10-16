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
package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.UUID;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class SqlDaoCallsAspectDiffblueTest {
  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    JDBCConnectionException jdbcConnectionException =
        new JDBCConnectionException("tenantId", new SQLException());
    when(signature.getParameterTypes()).thenThrow(jdbcConnectionException);

    // Act and Assert
    assertThrows(
        JDBCConnectionException.class,
        () -> sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[] {"Args"}));
    verify(signature).getParameterTypes();
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId2() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    JDBCConnectionException jdbcConnectionException =
        new JDBCConnectionException("tenantId", new SQLException());
    when(signature.getParameterNames()).thenThrow(jdbcConnectionException);

    // Act and Assert
    assertThrows(
        JDBCConnectionException.class,
        () ->
            sqlDaoCallsAspect.getTenantId(
                signature, "Method Name", new Object[] {ModelConstants.NULL_UUID}));
    verify(signature).getParameterNames();
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {null});

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(
            signature, "Method Name", new Object[] {ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Parameter Names}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithParameterNames() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(
            signature, "Method Name", new Object[] {ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Parameter Names}.
   *   <li>Then first element is {@code Args}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithParameterNames_thenFirstElementIsArgs() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});
    Object[] args = new Object[] {"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code tenantId} and {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithTenantIdAndFoo() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId", "foo"});
    Object[] args = new Object[] {"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code tenantId} and {@code foo}.
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithTenantIdAndFoo_thenReturnSys_tenant_id() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId", "foo"});

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(
            signature, "Method Name", new Object[] {ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MethodSignature} {@link MethodSignature#getParameterNames()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterNamesReturnNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(null);

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(
            signature, "Method Name", new Object[] {ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MethodSignature} {@link MethodSignature#getParameterTypes()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterTypesReturnNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterTypes()).thenReturn(null);
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});
    Object[] args = new Object[] {"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenOrgThingsboardServerCommonDataIdTenantId() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    Class<TenantId> forNameResult = TenantId.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    Object[] args = new Object[] {"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Then first element is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_thenFirstElementIsSys_tenant_id() {
    // Arrange
    Object[] args = new Object[] {ModelConstants.SYSTEM_TENANT};

    // Act
    TenantId actualTenantId =
        new SqlDaoCallsAspect().getTenantId(mock(MethodSignature.class), "Method Name", args);

    // Assert
    assertEquals(1, args.length);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualTenantId);
    assertSame(tenantId, args[0]);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with randomUUID.
   *   <li>Then return EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenArrayOfObjectWithRandomUUID_thenReturnEntityTypeIsTenant() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();

    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId", "foo"});
    UUID randomUUIDResult = UUID.randomUUID();

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[] {randomUUIDResult});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(randomUUIDResult, actualTenantId.getId());
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When empty array of {@link Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenEmptyArrayOfObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SqlDaoCallsAspect()
            .getTenantId(mock(MethodSignature.class), "Method Name", new Object[] {}));
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodSignature}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenMethodSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SqlDaoCallsAspect().getTenantId(mock(MethodSignature.class), "Method Name", null));
  }
}
