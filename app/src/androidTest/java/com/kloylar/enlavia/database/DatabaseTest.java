package com.kloylar.enlavia.database;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.kloylar.enlavia.data.database.LocalDatabase;
import com.kloylar.enlavia.data.database.ReportDAO;
import com.kloylar.enlavia.model.ReportData;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private ReportDAO reportDao;
    private LocalDatabase db;
    private Context appContext;

    @Before
    public void createDb() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = Room.inMemoryDatabaseBuilder(appContext, LocalDatabase.class).build();
        reportDao = db.userDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeReportAndRead() throws Exception {
        ReportData reportData1 = ReportFactory.createReport(appContext, "descripcion del reporte");
        long id = reportDao.insertReport(reportData1);
        ReportData reportData2 = reportDao.loadByIds(id);
        Assert.assertEquals(reportData1.timestamp, reportData2.timestamp);
        Assert.assertEquals(reportData1.description, reportData2.description);
    }

    @Test
    public void writeReport() throws Exception {
        ReportData reportData = ReportFactory.createReport(appContext, "descripcion del reporte");
        long id = reportDao.insertReport(reportData);
        Assert.assertTrue(id >=1);
    }
}
