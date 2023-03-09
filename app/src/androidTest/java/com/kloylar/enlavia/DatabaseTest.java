package com.kloylar.enlavia;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
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
        ReportData reportData = ReportFactory.createReport(appContext, "descripcion del reporte");
        long id = reportDao.insertReport(reportData);

        //List<User> byName = reportDao.findUsersByName("george");
        //assertThat(byName.get(0), equalTo(reportData));
    }

    @Test
    public void writeReport() throws Exception {
        ReportData reportData = ReportFactory.createReport(appContext, "descripcion del reporte");
        long id = reportDao.insertReport(reportData);
        Assert.assertTrue(id >=0);
    }
}
