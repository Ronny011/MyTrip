package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט", this
                .getResources().getString(R.string.shofet_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.hof_dor, "חוף דור-הבונים", this
                .getResources().getString(R.string.dor_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.nahal_sorek, "שפך נחל שורק", this
                .getResources().getString(R.string.sorek_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.kenion_adom, "הקניון האדום", "בדרום הרי אילת, כעשרים ק\"מ צפונית לעיר עצמה נמצא קניון. לא כזה שחנויות בו לרוב, אלא כזה שמתחתר באבן האדומה, אבן החול שמקורה בימים קדומים. מסלול קליל ומעגלי המתאים מאוד כעצירת התרעננות מ/ל-אילת"));
        modelClassList.add(new ModelClass(R.drawable.nahal_eiun, "נחל עיון", "בקצה הצפוני של הארץ, היכן שהאווירה גלילית ואחרת, זורם לו נחל עיון, המוכר בזכות מפל התנור, שמימיו צונחים מגובה של שלושים מטר אל תוך בריכה מרהיבה. אבל במסלול הקצר והנוח, שזורם בצידה של המושבה מטולה"));
        modelClassList.add(new ModelClass(R.drawable.ein_gedi, "עין גדי", "עין גדי, נחל דוד ונחל ערוגות הן שכיות חמדה מקסימות בנוף של מדבר יהודה. במקום תוכלו למצוא מעיינות זורמים, בית כנסת עתיק, מקדש מהתקופה הכלקוליתית, יעלים, שפנים ונוף יפה. ישנם מספר מסלולים אפשריים."));
        modelClassList.add(new ModelClass(R.drawable.mizpe_ofir, "מצפה אופיר", "על חודו של מצוק המשקיף מדרום רמת הגולן לכנרת, מחכה לכם מצפה אופיר: פנינת חמד אמיתית עם תצפית נוף מהממת לחרמון והרי הלבנון בצפון, לגליל, לעמקים ולהרי אום אל פאחם בדרום, אבל יותר מהכל - לכינרת."));
        modelClassList.add(new ModelClass(R.drawable.park_ariel_sharon,  "פארק\n אריאל שרון", "פארק אריאל שרון הנחשב לפרויקט הסביבתי השאפתני ביותר בישראל. הוא הופך את אתר חיריה, ששימש עשרות שנים כ\"חצר האחורית\" וכ\"פח האשפה\" של המטרופולין, לחלון הראווה הייצוגי של גוש דן."));
        modelClassList.add(new ModelClass(R.drawable.har_meron,  "הר מירון", "הַר מֵירוֹן הוא ההר הגבוה ביותר בשטח ארץ ישראל ממערב לירדן. הוא שוכן בסמוך לערים צפת ומעלות תרשיחא ופסגתו מתנשאת לגובה של 1,204 מטר מעל פני הים."));
        modelClassList.add(new ModelClass(R.drawable.nahal_snir,  "נחל\n שניר-חצבני", "אמרתם נחל בצפון, אמרתם שניר. הנחל, שהוא הארוך מבין שלושת מקורות הירדן, מתחיל את זרימתו בלבנון, ושם הוא נקרא אל-חצבאני."));
        modelClassList.add(new ModelClass(R.drawable.mearot,"ארץ\n אלף המערות", "פארק מערות עדולם משתרע על פני חמישים אלף דונם ונושק לישובים גבעת ישעיהו, צפרירים, ונחושה."));

        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
