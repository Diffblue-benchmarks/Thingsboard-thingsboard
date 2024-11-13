package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.resourceInfo.ResourceInfoCacheKey;
import org.thingsboard.server.cache.resourceInfo.ResourceInfoEvictEvent;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;

@ContextConfiguration(classes = {BaseResourceService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseResourceServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseResourceService baseResourceService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private ImageService imageService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private ResourceDataValidator resourceDataValidator;

  @MockBean
  private TbResourceDao tbResourceDao;

  @MockBean
  private TbResourceInfoDao tbResourceInfoDao;

  @MockBean
  private TbTransactionalCache<ResourceInfoCacheKey, TbResourceInfo> tbTransactionalCache;

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource());

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource(), true);

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbResource} {@link TbResource#getData()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate_givenNull_whenTbResourceGetDataReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource2.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource2).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource2).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#setEtag(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate_thenCallsSetEtag() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate_thenReturnTbResource() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource = new TbResource();
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource(), true);

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate_thenReturnTbResource2() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getId();
    verify(resource).getTenantId();
    verify(resource).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with
   * {@code resource}, {@code doValidate}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link TbResourceInfo#setEtag(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  public void testSaveResourceWithResourceDoValidate_whenFalse_thenCallsSetEtag() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource, false);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbResource} {@link TbResource#getData()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource_givenNull_whenTbResourceGetDataReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource2.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource2).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource2).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#setEtag(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource_thenCallsSetEtag() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource_thenReturnTbResource() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource = new TbResource();
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource());

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource_thenReturnTbResource2() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getId();
    verify(resource).getTenantId();
    verify(resource).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with
   * {@code resource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Id is
   * {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  public void testSaveResourceWithResource_whenTbResourceIdIsTbResourceIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbResource} {@link TbResource#getData()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_givenNull_whenTbResourceGetDataReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource2.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource).getData();
    verify(tbResource2).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource2).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link Dao#save(TenantId, Object)} return
   * {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_givenTbResourceDaoSaveReturnTbResource_thenReturnTbResource()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource).getData();
    verify(resource, atLeast(1)).getId();
    verify(resource).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    assertSame(tbResource, actualDoSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResourceInfo#getTenantId()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_givenTbResourceGetTenantIdReturnSystem_tenant() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource2);
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Given {@link TbResourceInfoDao} {@link Dao#save(TenantId, Object)} return
   * {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_givenTbResourceInfoDaoSaveReturnTbResourceInfo() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource resource = new TbResource();

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals(resource, actualDoSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(new TbResource());

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_thenThrowConstraintViolationException() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService.doSaveResource(resource));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource).getData();
    verify(resource).getId();
    verify(resource).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Id is
   * {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  public void testDoSaveResource_whenTbResourceIdIsTbResourceIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any())).thenReturn(tbResource);

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindResourceByTenantIdAndKey_thenReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResource);

    // Act
    TbResource actualFindResourceByTenantIdAndKeyResult = baseResourceService
        .findResourceByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    assertSame(tbResource, actualFindResourceByTenantIdAndKeyResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindResourceByTenantIdAndKey_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService
        .findResourceByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key"));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}.
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}
   */
  @Test
  public void testFindResourceById_whenTbResourceIdWithIdIsNull_uuid_thenReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tbResource);

    // Act
    TbResource actualFindResourceByIdResult = baseResourceService.findResourceById(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tbResource, actualFindResourceByIdResult);
  }

  /**
   * Test {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceData_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourceData = baseResourceService.getResourceData(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceData_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing getResourceData [{}] [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService
        .getResourceData(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(tbResourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}
   */
  @Test
  public void testFindResourceInfoById_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<ResourceInfoCacheKey>any(),
        Mockito.<Supplier<TbResourceInfo>>any(), anyBoolean())).thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindResourceInfoByIdResult = baseResourceService
        .findResourceInfoById(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(tbResourceInfo, actualFindResourceInfoByIdResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindResourceInfoByTenantIdAndKey_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindResourceInfoByTenantIdAndKeyResult = baseResourceService
        .findResourceInfoByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceInfoDao).findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    assertSame(tbResourceInfo, actualFindResourceInfoByTenantIdAndKeyResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindResourceInfoByTenantIdAndKey_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceInfoDao.findByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findResourceInfoByTenantIdAndKey [{}] [{}] [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService
        .findResourceInfoByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key"));
    verify(tbResourceInfoDao).findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
  }

  /**
   * Test
   * {@link BaseResourceService#findResourceInfoByIdAsync(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findResourceInfoByIdAsync(TenantId, TbResourceId)}
   */
  @Test
  public void testFindResourceInfoByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<TbResourceInfo> createResult = SettableFuture.create();
    when(tbResourceInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<TbResourceInfo> actualFindResourceInfoByIdAsyncResult = baseResourceService
        .findResourceInfoByIdAsync(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindResourceInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindResourceInfoByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   * with {@code tenantId}, {@code resourceId}, {@code force}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceIdForce() {
    // Arrange
    doThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]"))
        .when(tbResourceDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TbResource());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService
        .deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   * with {@code tenantId}, {@code resourceId}, {@code force}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceIdForce2() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true);

    // Assert that nothing has changed
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   * with {@code tenantId}, {@code resourceId}, {@code force}.
   * <ul>
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceIdForce_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TbResource());

    // Act
    baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with
   * {@code tenantId}, {@code resourceId}.
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceId_givenTbResourceDaoFindByIdReturnNull() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing().when(resourceDataValidator).validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with
   * {@code tenantId}, {@code resourceId}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceId_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TbResource());
    doNothing().when(resourceDataValidator).validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with
   * {@code tenantId}, {@code resourceId}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  public void testDeleteResourceWithTenantIdResourceId_thenThrowConstraintViolationException() {
    // Arrange
    doThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]"))
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService
        .deleteResource(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findAllTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = baseResourceService
        .findAllTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao).findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindAllTenantResourcesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindAllTenantResourcesByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceInfoDao.findAllTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(),
        Mockito.<PageLink>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findAllTenantResourcesByTenantId [{}]"));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.findAllTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceInfoDao).findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = baseResourceService
        .findTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao).findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindTenantResourcesByTenantIdResult.EMPTY_PAGE_DATA, actualFindTenantResourcesByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceInfoDao.findTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findTenantResourcesByTenantId [{}]"));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.findTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceInfoDao).findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])}
   */
  @Test
  public void testFindTenantResourcesByResourceTypeAndObjectIds() {
    // Arrange
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<ResourceSubType>any(), Mockito.<String[]>any(), Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndObjectIds [{}][{}][{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.findTenantResourcesByResourceTypeAndObjectIds(ModelConstants.SYSTEM_TENANT,
            ResourceType.LWM2M_MODEL, new String[]{"Object Ids"}));
    verify(tbResourceDao).findResourcesByTenantIdAndResourceType(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        isNull(), isA(String[].class), isNull());
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])}
   */
  @Test
  public void testFindTenantResourcesByResourceTypeAndObjectIds_thenReturnEmpty() {
    // Arrange
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<ResourceSubType>any(), Mockito.<String[]>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindTenantResourcesByResourceTypeAndObjectIdsResult = baseResourceService
        .findTenantResourcesByResourceTypeAndObjectIds(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            new String[]{"Object Ids"});

    // Assert
    verify(tbResourceDao).findResourcesByTenantIdAndResourceType(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        isNull(), isA(String[].class), isNull());
    assertTrue(actualFindTenantResourcesByResourceTypeAndObjectIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}
   */
  @Test
  public void testFindAllTenantResources_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResource> actualFindAllTenantResourcesResult = baseResourceService
        .findAllTenantResources(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindAllTenantResourcesResult.EMPTY_PAGE_DATA, actualFindAllTenantResourcesResult);
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByResourceTypeAndPageLink() {
    // Arrange
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<ResourceSubType>any(), Mockito.<PageLink>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndPageLink [{}][{}][{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.findTenantResourcesByResourceTypeAndPageLink(ModelConstants.SYSTEM_TENANT,
            ResourceType.LWM2M_MODEL, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceDao).findResourcesByTenantIdAndResourceType(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        isNull(), isA(PageLink.class));
  }

  /**
   * Test
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByResourceTypeAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<ResourceSubType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResource> actualFindTenantResourcesByResourceTypeAndPageLinkResult = baseResourceService
        .findTenantResourcesByResourceTypeAndPageLink(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceDao).findResourcesByTenantIdAndResourceType(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        isNull(), isA(PageLink.class));
    assertSame(actualFindTenantResourcesByResourceTypeAndPageLinkResult.EMPTY_PAGE_DATA,
        actualFindTenantResourcesByResourceTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link TbResourceDao#findAllByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteResourcesByTenantId_thenCallsFindAllByTenantId() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseResourceService.deleteResourcesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteResourcesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    ArrayList<TbResource> data = new ArrayList<>();
    data.add(tbResource);
    PageData<TbResource> pageData = new PageData<>(data, 100, 100L, true);

    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing deleteResourcesByTenantId, tenantId [{}]")).when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.deleteResourcesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link TbResourceDao#findAllByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindAllByTenantId() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseResourceService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    ArrayList<TbResource> data = new ArrayList<>();
    data.add(tbResource);
    PageData<TbResource> pageData = new PageData<>(data, 100, 100L, true);

    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing deleteResourcesByTenantId, tenantId [{}]")).when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<ResourceInfoCacheKey>any(),
        Mockito.<Supplier<TbResourceInfo>>any(), anyBoolean())).thenReturn(tbResourceInfo);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseResourceService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tbResourceInfo, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseResourceService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseResourceService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    // Act and Assert
    assertEquals(EntityType.TB_RESOURCE,
        (new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator())).getEntityType());
  }

  /**
   * Test {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  public void testSumDataSizeByTenantId_thenReturnOne() {
    // Arrange
    when(tbResourceDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualSumDataSizeByTenantIdResult = baseResourceService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).sumDataSizeByTenantId(isA(TenantId.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult);
  }

  /**
   * Test {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  public void testSumDataSizeByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(tbResourceDao.sumDataSizeByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseResourceService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbResourceDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}
   */
  @Test
  public void testCreateOrUpdateSystemResource() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    TbResource tbResource2 = new TbResource();
    tbResource2.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.</li>
   *   <li>Then calls {@link TbResourceInfo#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}
   */
  @Test
  public void testCreateOrUpdateSystemResource_givenTbTransactionalCache_thenCallsGetId() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(new TbResource());
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#getCreatedTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}
   */
  @Test
  public void testCreateOrUpdateSystemResource_thenCallsGetCreatedTime() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.getData()).thenReturn(null);
    when(tbResource2.getCreatedTime()).thenReturn(1L);
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource2).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource2).setId(Mockito.<TbResourceId>any());
    tbResource2.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResource2);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource3 = new TbResource();
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource3);

    // Act
    TbResource actualCreateOrUpdateSystemResourceResult = baseResourceService
        .createOrUpdateSystemResource(ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource2, atLeast(1)).getData();
    verify(tbResource2).setData(isA(byte[].class));
    verify(tbResource2).getCreatedTime();
    verify(tbResource2, atLeast(1)).getId();
    verify(tbResource2, atLeast(1)).getTenantId();
    verify(tbResource2).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource3, actualCreateOrUpdateSystemResourceResult);
  }

  /**
   * Test
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#setEtag(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}
   */
  @Test
  public void testCreateOrUpdateSystemResource_thenCallsSetEtag() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    TbResource tbResource2 = mock(TbResource.class);
    doNothing().when(tbResource2).setEtag(Mockito.<String>any());
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource2).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource2).setId(Mockito.<TbResourceId>any());
    tbResource2.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResource2);
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource2, atLeast(1)).getData();
    verify(tbResource2).setData(isA(byte[].class));
    verify(tbResource).getId();
    verify(tbResource2, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(tbResource2).getTenantId();
    verify(tbResource2).setEtag(eq("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc"));
    verify(tbResource2).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}
   */
  @Test
  public void testCreateOrUpdateSystemResource_thenReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any())).thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(new TbResource());
    when(resourceDataValidator.validate(Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualCreateOrUpdateSystemResourceResult = baseResourceService
        .createOrUpdateSystemResource(ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao).findResourceByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL),
        eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualCreateOrUpdateSystemResourceResult);
  }

  /**
   * Test
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}
   */
  @Test
  public void testCheckSystemResourcesUsage_thenReturn138140001dd211b28080808080808080() {
    // Arrange
    when(tbResourceInfoDao.findByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(new TbResourceInfo(new TbResourceId(ModelConstants.NULL_UUID)));

    // Act
    String actualCheckSystemResourcesUsageResult = baseResourceService.checkSystemResourcesUsage("${RESOURCE:U}",
        ResourceType.LWM2M_MODEL);

    // Assert
    verify(tbResourceInfoDao).findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCheckSystemResourcesUsageResult);
  }

  /**
   * Test
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}
   */
  @Test
  public void testCheckSystemResourcesUsage_thenReturnEmptyString() {
    // Arrange
    when(tbResourceInfoDao.findByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(null);

    // Act
    String actualCheckSystemResourcesUsageResult = baseResourceService.checkSystemResourcesUsage("${RESOURCE:U}",
        ResourceType.LWM2M_MODEL);

    // Assert
    verify(tbResourceInfoDao).findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
    assertEquals("", actualCheckSystemResourcesUsageResult);
  }

  /**
   * Test
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}
   */
  @Test
  public void testCheckSystemResourcesUsage_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        baseResourceService.checkSystemResourcesUsage("Not all who wander are lost", ResourceType.LWM2M_MODEL));
  }

  /**
   * Test {@link BaseResourceService#calculateEtag(byte[])}.
   * <p>
   * Method under test: {@link BaseResourceService#calculateEtag(byte[])}
   */
  @Test
  public void testCalculateEtag() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseResourceService.calculateEtag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   * with {@code ResourceInfoEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithResourceInfoEvictEvent() {
    // Arrange
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"))
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseResourceService.handleEvictEvent(
        new ResourceInfoEvictEvent(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID))));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
  }

  /**
   * Test {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   * with {@code ResourceInfoEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithResourceInfoEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    // Act
    baseResourceService.handleEvictEvent(
        new ResourceInfoEvictEvent(ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
  }
}
