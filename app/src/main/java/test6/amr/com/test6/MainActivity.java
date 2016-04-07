package test6.amr.com.test6;
//

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shahroz.svlibrary.interfaces.onSearchListener;
import com.shahroz.svlibrary.interfaces.onSimpleSearchActionsListener;
import com.shahroz.svlibrary.widgets.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks,onSimpleSearchActionsListener, onSearchListener {

    private boolean searchActive = false;
    private boolean mSearchViewAdded = false;

    @Override
    public void onSearch(String query) {

    }

    @Override
    public void searchViewOpened() {
        Toast.makeText(MainActivity.this, "Search View Opened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchViewClosed() {
    }

    @Override
    public void onItemClicked(String item) {
        Toast.makeText(MainActivity.this,item + " clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScroll() {

    }

    @Override
    public void error(String localizedMessage) {

    }

    @Override
    public void onCancelSearch() {
        searchActive = false;
        mSearchView.hide();
    }

    private Toolbar mToolbar;
    ListView listView;
    SearchManager searchManager;
    private WindowManager mWindowManager;
    SearchView searchView;
     MenuItem searchItem;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private MaterialSearchView mSearchView;


    String one_title = "لو جالك عقد عمل فى الخليج";
    String one_situation = "فى حالة لو جالك شغل فى أى دولة خليجية بتكون محتاج شوية إجراءات تعملها فى الورق ، أولاً محتاج تستخرج شهادة التخرج بتاعتك من الجامعة بالعربى معتمدة من الجامعة وبعد كده تتوثق فى الخارجية لها كذا مكتب هتلاقيهم فى الرابط ده" +
            "http://www.mfa.gov.eg/Arabic/ConsularServices/TravelGuide/Ratifications/Pages/Default.aspx\n" +
            "بعد كده تروحبيها على سفارة الدولة المفروض هتشتغل فيها عشان توثقها" +
            "المكان اللى هتشتغل فيه بيكون طالب دائماً صورة ضوئية لشهادة التخرج معتمدة من الجامعة وموثقة من الخارجية ومن سفارتها\n" +
            "ملاحظات:" +
            "-ممكن لو أنت فى مرحلة البحث عن عمل تشتغل فى الإجراءات ديه عشان أما تجيلك فرصة تعرف تتحرك أسرع" +
            "- دولة الإمارات التوثيق بيكون على مرحلتين الأولى فى المحلق الثقافى للسفارة والتانى بيكون فى السفارة نفسها";
    String one_date = "2014-03-24";
    ///////////////////////////////////////////////////////////////////////////
    String two_title = "إذن السفر للخارج";
    String two_situation = "اي شخص حاصل على اعفاء مؤقت أو طالب أو تأجيل ومكتوب في الشهاده اللي معاه انه غير مصرح له بالسفر الا بإذن ممكن ياخد اذن من منطقه التجنيد التابع ليها بمنتهى السهوله وبياخدها في نفس اليوم كمان" +
            "إذن السفر للخارج : اي شخص حاصل على اعفاء مؤقت أو طالب أو تأجيل ومكتوب في الشهاده اللي معاه انه غير مصرح له بالسفر الا بإذن ممكن ياخد اذن من منطقه التجنيد التابع ليها بمنتهى السهوله وبياخدها في نفس اليوم كمان الاوراق المطلوبه للحصول على إذن السفر بالخارج : 1- عدد 2 صورة من الباسبور 2- صورة واحده من التأشيره 3- صورة واحده من البطاقه 4- صورة واحده من شهاده الموقف التجنيدي سواء اعفاء مؤقت أو تأجيل 5- بون اسمه بون اذونات سفر للخارج بتجيبه من داخل منطقه التجنيد بجوار مكتب الحصول على إذن بالسفر للخارج وقيمه البون بتختلف حسب السنه اللي اتولدت فيها بس السعر بيتراوح من 15 جنيه لحد 40 جنيه بالكتير أوي 6- يفضل لو معاك أصل لشهاده موقفك التجنيدي احتياطي فقط لا غير لكن مش ضروري أوي اما بالنسبه للطلبه : الاوراق المطلوبه للحصول على إذن السفر بالخارج في اجازة نصف العام أو اجازة أخر العام الدراسي : 1- عدد 2 صورة من الباسبور 2- صورة واحده من التأشيره 3- صورة واحده من البطاقه 4- شهادة قيد من الكليه أو المعهد اللي بتدرس فيه 5- بون اسمه بون اذونات سفر للخارج بتجيبه من داخل منطقه التجنيد بجوار مكتب الحصول على إذن بالسفر للخارج وقيمه البون بتختلف حسب السنه اللي اتولدت فيها بس السعر بيتراوح من 15 جنيه لحد 40 جنيه بالكتير أو الخطوات المطلوبه للحصول على اذن السفر للخارج : بمنتهى البساطه بتروح الاول بتسأل داخل منطقه التجنيد على الشباك بتاع اذن السفر للخارج حتلاقيه وحتلاقي جنبه الشباك بتاع الخزنه اللي حتجيب منه بون اذونات السفر للخارج روح الأول لشباك الخزنه واشتري منه بون اذونات السفر للخارج وحتلاقيه حيديك بون للتصوير كمان عشان لو احتجت تصور اي ورق سواء الباسبور او البطاقه اوالتأشيره مسموحلك بالبون ده تصور من غير فلوس في ماكنه التصوير لموجوده بمنطقه التجنيد المهم بعد ما حيكون معاك البون والصور من الورق المطلوب روح لشباك اذن السفر للخارج واديه للموظف او الموظفه الموجوده حتقولك استريح شويه وحتنادي على اسمك في ربع ساعه بالكتير ومبروك عليك إذن السفر بالخارج";
    String two_date = "2013-05-19";
    ///////////////////////////////////////////////////////////////////////////
    String three_title = "فيزا أمريكا ";
    String three_situation = "احنا مجموعة من طلبة كلية الهندسة ... كان عندنا مسابقة في أمريكا... وروحنا نقدم على فيزا أمريكا... ومعانا كل الدعم والورق اللي يثبت ان حنا بنمثل الكية ومصر في المسابقة, وأنوا معانا دعم مادي لمشروع التخرج من شركات كبرى في اسكندرية... المهم دخلنا انترفيو جماعي بكل الورق ده... واترفضنا !! بعد كده قدمنا كل واحد لوحده وفي ناس خدتها بشوية النصايح اللي تحت دي" +
            "1-\tروح ادفع في ال CIB BANK مبلغ 1120 ج 2-\tكلم فودافون على 2100 عشان تحجز معاد، الدقيقة ب 5.05 ج ، تقريبا بتدوس 1 1 1 عشان تختصر 5 دقايق من التسجيل الصوتي وتكلم مندوب فودافون على طول ... لو انت طالع مسابقة أو مؤتمر ومعاك invitation letter قلهم عايز ميعاد business غالبا ده بيديك معاد أسرع من المواعيد العادية ..وبتكون ال visa type هو business 3-\tبتملى ال DS 160 FORM اللي هي الابليكشن من على ceac.state.gov/genniv 4-\tFor cancellation call 0225224890 قبل المعاد ب 48 ساعة على الأقل وتبقى تاخد معاد في وقت تاني عشان الحجز مايروحش عاليك 5-\tكون لابس كويس... احسن حاجة عندك.. مش شرط فورمال... عشان للاسف بيطروا يحكموا من ابمنظر...روح السفارة قبل معادك بنص ساعة وكون محضر كلامك كويس وواثق في نفسك في الانترفيو وخليك مبتسم وفريش وحاول يكون في كلامك بطريقة غير مباشرة ان في روابط قوية تربطك بالبلد وانك مش محتاجلهم في حاجة .. شوية انافة بتنفع برضوا ... الأهم من الورق اللي معاك ..طريقة كلامك وثقتك في الكلام اللي بتقولوا.. مش بعيد تسجل لنفسك انترفيوا وتظبطوا كذا مرة لحاد ما تتقنوا وتحضر نفسك لكل أنواع الأسئلة اللي ممكن تتسألها وردك يكون جاهز ووقتي عاليها بدون ما يكون في أي تناقضات في الردود.. الانترفيو ممكن مسعديش اريع دقايق...فقول اكتر جملتين تجذبهم عشان يدوك الفيزا أول جملتين.. فكرة الانطباع الاول مهمة جدا هنا" +
            "ملاحظات\n" +
            "* مفيش أي حد جوه السفارة نهائيا له يد في قرار الفيزا بتاعك غير القنصل اللي عالشباك ... متقلقش نفسك عالفاضي مع أي موظف تاني زي اللي بياخد منك الباسبورت أو اللي بيبصمك أو اللي بيتاكد ان اسمك موجود عندهم متسجل في اليوم ده وبيدبسلك الصورة في الباسبور... مش مهم تكون قلقان قدام دول كلهم ... المهم متكونش قلقان قدام القنصل اللي عالشباك" +
            "* لو انت اترفضت نصيحتي ليك قدم تاني على طول ...ده لو انت شايف ان حقك تسافر وكان قرار الرفض ظالم ليك.. لان في القانون عندهم مش حيكون نفس القنصل اللي عملك الانترفيو وحيبقى قنصل تاني ... مادام قدمت تاني قبل سنة من المعاد الاولاني ... دايما بيكون في قنصل معدل رفضه للفيزا ابليكيشن اعلى من غيره ..يعني هي مسألة حظوظ انت داخل على انهي قنصل... فلو كان حظك وحش ودخلت اول مرة لقنصل معدل رفضه لاعطاء الفيزا عالي... المرة اللي بعدها لو في خلال سنة مش حتخشله تاني... ولو دخلتله قله انو عملك انترفيو من 3 شهور مثلا فهو حيخليك تخش على شباك تاني وربنا يكرمك المره دي !" +

            "*اوعى ابدا تخش انترفيو جماعي الا لو معاك انفيتاشن او اسرة واحدة ... لأن القنصل يا أما حيديكوا كلكوا الفيزا أو يديكوا رفض و الاسهله 1000 مرة ان يرفضكوا كلكوا حتى لو هوا شاف ان واحد فيكوا بس يستحق الرفض...حيرفض المجموعة كلها... عشان كده دايما على قد ما تقدروا ابعدوا عن الجروب انترفيو !!";
    String three_date = "2013-05-10";
    ///////////////////////////////////////////////////////////////////////////
    String four_title = "فيزا انجلترا";
    String four_situation = "دي خطوات تضمن بيها انك تاخد فيزا انجلترا (سياحة) بكل سهولة ان شاء الله اول حاجة عايز اقولها ان الفيزا اسهل كتير انك طالب في كلية .. لان ببساطة دة يعتبر اثبات قوي انك مرتبط بالبلد و احتمال هروبك بيقل وطبعا كل ما كنت في السنوات الاولى من الدراسة بيبقى افضل (ودة بينطبق على كل السفارات مش سفارة انجلترا بس. فيزا انجلترا بتدخلك انجلترا و اسكتلندا و ايرلندا و ويلز ( المملكة المتحدة) مفيش انترفيو عشان تاخد الفيزا الا في حدود ضيقة جدا ممكن نقول نسبة 1% بس في الاساس مفيش انترفيو الورق اللي مطلوب: 1-تملى الابلكيشن من هنا https://www.visa4uk.fco.gov.uk/ وبعد ما تملاه لازم تدفع اون لاين عشان تقدر تطبعه وتاخده معاك و انت بتقدم .. طبعا هتحتاج انترنت كارد عشان تدفع (سعر الفيزا وقت كتابة الخبرة دي 132 دولار). 2-بعد ما تدفع هتدخل على الموقع دة عشان تحجز معاد للمقابلة https://www.visainfoservices.com/ . 3- هتطلع شهادة قيد لو كنت طالب .. او ورق من شغلك بمرتبك لو كنت بتشتغل.. او بطاقتك الضريبية والسجل التجاري لو كنت صاحب عمل. 4- بنك ستيتمنت (كشف حساب) و دة مهم جدا لانه بيبين هتقدر تغطي مصاريفك هناك ولا لا. لو طالب ممكن 30 الف جنيه كافيين جدا في كشف الحساب .. في الحالات التانية مش عارف بالظبط بس اكيد لو اكتر احسن بكتير. 5-طبعا كل الورق دة يا اما يطلع انجليزي اصلا يا اما لازم تترجمه ومش لازم ترجمة معتمدة (كنت بترجمه بنفسي عالسرير واروح بيه عادي) 7-صورتين 4 في 6 خلفية بيضا زي بتاعت الباسبور. وتاخد بعضك وتروح على مكتب الوورلد بردج هتسلم ورقك وباسبورك وياخدوا بصمتك وهتستنى باسبورك هيجيلك بالدي اتش ال وعليه الفيزا ان شاء الله..";
    String four_date = "2013-05-16";
    /////////////////////////////////////////////////////////////////////////

    String[] Name = {one_title, four_title, three_title,two_title};
    String[] Date = {one_date, four_date, three_date, two_date};
    String[] Description = {one_situation, four_situation, three_situation, two_situation};
    int[] Image = {R.drawable.test, R.drawable.one, R.drawable.two, R.drawable.three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mSearchView = new MaterialSearchView(this);
        mSearchView.setOnSearchListener(this);
        mSearchView.setSearchResultsListener(this);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new MAdapter(this, Name, Date, Description, Image));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ReviewsPopUp.class);
                i.putExtra("name", Name[position]);
                i.putExtra("date", Date[position]);
                i.putExtra("description", Description[position]);
                startActivity(i);
               //finish();
            } });
        if (mToolbar != null) {
            // Delay adding SearchView until Toolbar has finished loading
            mToolbar.post(new Runnable() {
                @Override
                public void run() {
                    if (!mSearchViewAdded && mWindowManager != null) {
                        mWindowManager.addView(mSearchView,
                                MaterialSearchView.getSearchViewLayoutParams(MainActivity.this));
                        mSearchViewAdded = true;
                    }
                }
            });
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.main, menu);
        // Associate searchable configuration with the SearchView
         searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//         searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));

//        searchItem = menu.findItem(R.id.search);
//        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                mSearchView.display();
//                openKeyboard();
//                return true;
//            }
//        });
//        searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setSearchableInfo(searchManager.
//                getSearchableInfo(getComponentName()));
//        searchView.setSubmitButtonEnabled(true);
//        searchView.setOnQueryTextListener(this);
        searchItem = menu.findItem(R.id.search);
        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                mSearchView.display();
                openKeyboard();
                return true;
            }
        });
        if(searchActive)
            mSearchView.display();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {  switch (item.getItemId())
        { case R.id.menu_1:
            Intent i = new Intent(MainActivity.this, Add.class);
            startActivity(i);
            finish();
           return true;
           default:
                return super.onOptionsItemSelected(item);}

    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }

    private void openKeyboard() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0));
                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0, 0, 0));
            }
        }, 200);
    }

}

//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.SystemClock;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.shahroz.svlibrary.interfaces.onSearchListener;
//import com.shahroz.svlibrary.interfaces.onSimpleSearchActionsListener;
//import com.shahroz.svlibrary.utils.Util;
//import com.shahroz.svlibrary.widgets.MaterialSearchView;
//
//public class MainActivity extends AppCompatActivity implements onSimpleSearchActionsListener, onSearchListener {
//
//
//    private NavigationDrawerFragment mNavigationDrawerFragment;
//
//
//    String one_title = "لو جالك عقد عمل فى الخليج";
//    String one_situation = "فى حالة لو جالك شغل فى أى دولة خليجية بتكون محتاج شوية إجراءات تعملها فى الورق ، أولاً محتاج تستخرج شهادة التخرج بتاعتك من الجامعة بالعربى معتمدة من الجامعة وبعد كده تتوثق فى الخارجية لها كذا مكتب هتلاقيهم فى الرابط ده" +
//            "http://www.mfa.gov.eg/Arabic/ConsularServices/TravelGuide/Ratifications/Pages/Default.aspx\n" +
//            "بعد كده تروحبيها على سفارة الدولة المفروض هتشتغل فيها عشان توثقها" +
//            "المكان اللى هتشتغل فيه بيكون طالب دائماً صورة ضوئية لشهادة التخرج معتمدة من الجامعة وموثقة من الخارجية ومن سفارتها\n" +
//            "ملاحظات:" +
//            "-ممكن لو أنت فى مرحلة البحث عن عمل تشتغل فى الإجراءات ديه عشان أما تجيلك فرصة تعرف تتحرك أسرع" +
//            "- دولة الإمارات التوثيق بيكون على مرحلتين الأولى فى المحلق الثقافى للسفارة والتانى بيكون فى السفارة نفسها";
//    String one_date = "2014-03-24";
//    ///////////////////////////////////////////////////////////////////////////
//    String two_title = "إذن السفر للخارج";
//    String two_situation = "اي شخص حاصل على اعفاء مؤقت أو طالب أو تأجيل ومكتوب في الشهاده اللي معاه انه غير مصرح له بالسفر الا بإذن ممكن ياخد اذن من منطقه التجنيد التابع ليها بمنتهى السهوله وبياخدها في نفس اليوم كمان" +
//            "إذن السفر للخارج : اي شخص حاصل على اعفاء مؤقت أو طالب أو تأجيل ومكتوب في الشهاده اللي معاه انه غير مصرح له بالسفر الا بإذن ممكن ياخد اذن من منطقه التجنيد التابع ليها بمنتهى السهوله وبياخدها في نفس اليوم كمان الاوراق المطلوبه للحصول على إذن السفر بالخارج : 1- عدد 2 صورة من الباسبور 2- صورة واحده من التأشيره 3- صورة واحده من البطاقه 4- صورة واحده من شهاده الموقف التجنيدي سواء اعفاء مؤقت أو تأجيل 5- بون اسمه بون اذونات سفر للخارج بتجيبه من داخل منطقه التجنيد بجوار مكتب الحصول على إذن بالسفر للخارج وقيمه البون بتختلف حسب السنه اللي اتولدت فيها بس السعر بيتراوح من 15 جنيه لحد 40 جنيه بالكتير أوي 6- يفضل لو معاك أصل لشهاده موقفك التجنيدي احتياطي فقط لا غير لكن مش ضروري أوي اما بالنسبه للطلبه : الاوراق المطلوبه للحصول على إذن السفر بالخارج في اجازة نصف العام أو اجازة أخر العام الدراسي : 1- عدد 2 صورة من الباسبور 2- صورة واحده من التأشيره 3- صورة واحده من البطاقه 4- شهادة قيد من الكليه أو المعهد اللي بتدرس فيه 5- بون اسمه بون اذونات سفر للخارج بتجيبه من داخل منطقه التجنيد بجوار مكتب الحصول على إذن بالسفر للخارج وقيمه البون بتختلف حسب السنه اللي اتولدت فيها بس السعر بيتراوح من 15 جنيه لحد 40 جنيه بالكتير أو الخطوات المطلوبه للحصول على اذن السفر للخارج : بمنتهى البساطه بتروح الاول بتسأل داخل منطقه التجنيد على الشباك بتاع اذن السفر للخارج حتلاقيه وحتلاقي جنبه الشباك بتاع الخزنه اللي حتجيب منه بون اذونات السفر للخارج روح الأول لشباك الخزنه واشتري منه بون اذونات السفر للخارج وحتلاقيه حيديك بون للتصوير كمان عشان لو احتجت تصور اي ورق سواء الباسبور او البطاقه اوالتأشيره مسموحلك بالبون ده تصور من غير فلوس في ماكنه التصوير لموجوده بمنطقه التجنيد المهم بعد ما حيكون معاك البون والصور من الورق المطلوب روح لشباك اذن السفر للخارج واديه للموظف او الموظفه الموجوده حتقولك استريح شويه وحتنادي على اسمك في ربع ساعه بالكتير ومبروك عليك إذن السفر بالخارج";
//    String two_date = "2013-05-19";
//    ///////////////////////////////////////////////////////////////////////////
//    String three_title = "فيزا أمريكا ";
//    String three_situation = "احنا مجموعة من طلبة كلية الهندسة ... كان عندنا مسابقة في أمريكا... وروحنا نقدم على فيزا أمريكا... ومعانا كل الدعم والورق اللي يثبت ان حنا بنمثل الكية ومصر في المسابقة, وأنوا معانا دعم مادي لمشروع التخرج من شركات كبرى في اسكندرية... المهم دخلنا انترفيو جماعي بكل الورق ده... واترفضنا !! بعد كده قدمنا كل واحد لوحده وفي ناس خدتها بشوية النصايح اللي تحت دي" +
//            "1-\tروح ادفع في ال CIB BANK مبلغ 1120 ج 2-\tكلم فودافون على 2100 عشان تحجز معاد، الدقيقة ب 5.05 ج ، تقريبا بتدوس 1 1 1 عشان تختصر 5 دقايق من التسجيل الصوتي وتكلم مندوب فودافون على طول ... لو انت طالع مسابقة أو مؤتمر ومعاك invitation letter قلهم عايز ميعاد business غالبا ده بيديك معاد أسرع من المواعيد العادية ..وبتكون ال visa type هو business 3-\tبتملى ال DS 160 FORM اللي هي الابليكشن من على ceac.state.gov/genniv 4-\tFor cancellation call 0225224890 قبل المعاد ب 48 ساعة على الأقل وتبقى تاخد معاد في وقت تاني عشان الحجز مايروحش عاليك 5-\tكون لابس كويس... احسن حاجة عندك.. مش شرط فورمال... عشان للاسف بيطروا يحكموا من ابمنظر...روح السفارة قبل معادك بنص ساعة وكون محضر كلامك كويس وواثق في نفسك في الانترفيو وخليك مبتسم وفريش وحاول يكون في كلامك بطريقة غير مباشرة ان في روابط قوية تربطك بالبلد وانك مش محتاجلهم في حاجة .. شوية انافة بتنفع برضوا ... الأهم من الورق اللي معاك ..طريقة كلامك وثقتك في الكلام اللي بتقولوا.. مش بعيد تسجل لنفسك انترفيوا وتظبطوا كذا مرة لحاد ما تتقنوا وتحضر نفسك لكل أنواع الأسئلة اللي ممكن تتسألها وردك يكون جاهز ووقتي عاليها بدون ما يكون في أي تناقضات في الردود.. الانترفيو ممكن مسعديش اريع دقايق...فقول اكتر جملتين تجذبهم عشان يدوك الفيزا أول جملتين.. فكرة الانطباع الاول مهمة جدا هنا" +
//            "ملاحظات\n" +
//            "* مفيش أي حد جوه السفارة نهائيا له يد في قرار الفيزا بتاعك غير القنصل اللي عالشباك ... متقلقش نفسك عالفاضي مع أي موظف تاني زي اللي بياخد منك الباسبورت أو اللي بيبصمك أو اللي بيتاكد ان اسمك موجود عندهم متسجل في اليوم ده وبيدبسلك الصورة في الباسبور... مش مهم تكون قلقان قدام دول كلهم ... المهم متكونش قلقان قدام القنصل اللي عالشباك" +
//            "* لو انت اترفضت نصيحتي ليك قدم تاني على طول ...ده لو انت شايف ان حقك تسافر وكان قرار الرفض ظالم ليك.. لان في القانون عندهم مش حيكون نفس القنصل اللي عملك الانترفيو وحيبقى قنصل تاني ... مادام قدمت تاني قبل سنة من المعاد الاولاني ... دايما بيكون في قنصل معدل رفضه للفيزا ابليكيشن اعلى من غيره ..يعني هي مسألة حظوظ انت داخل على انهي قنصل... فلو كان حظك وحش ودخلت اول مرة لقنصل معدل رفضه لاعطاء الفيزا عالي... المرة اللي بعدها لو في خلال سنة مش حتخشله تاني... ولو دخلتله قله انو عملك انترفيو من 3 شهور مثلا فهو حيخليك تخش على شباك تاني وربنا يكرمك المره دي !" +
//
//            "*اوعى ابدا تخش انترفيو جماعي الا لو معاك انفيتاشن او اسرة واحدة ... لأن القنصل يا أما حيديكوا كلكوا الفيزا أو يديكوا رفض و الاسهله 1000 مرة ان يرفضكوا كلكوا حتى لو هوا شاف ان واحد فيكوا بس يستحق الرفض...حيرفض المجموعة كلها... عشان كده دايما على قد ما تقدروا ابعدوا عن الجروب انترفيو !!";
//    String three_date = "2013-05-10";
//    ///////////////////////////////////////////////////////////////////////////
//    String four_title = "فيزا انجلترا";
//    String four_situation = "دي خطوات تضمن بيها انك تاخد فيزا انجلترا (سياحة) بكل سهولة ان شاء الله اول حاجة عايز اقولها ان الفيزا اسهل كتير انك طالب في كلية .. لان ببساطة دة يعتبر اثبات قوي انك مرتبط بالبلد و احتمال هروبك بيقل وطبعا كل ما كنت في السنوات الاولى من الدراسة بيبقى افضل (ودة بينطبق على كل السفارات مش سفارة انجلترا بس. فيزا انجلترا بتدخلك انجلترا و اسكتلندا و ايرلندا و ويلز ( المملكة المتحدة) مفيش انترفيو عشان تاخد الفيزا الا في حدود ضيقة جدا ممكن نقول نسبة 1% بس في الاساس مفيش انترفيو الورق اللي مطلوب: 1-تملى الابلكيشن من هنا https://www.visa4uk.fco.gov.uk/ وبعد ما تملاه لازم تدفع اون لاين عشان تقدر تطبعه وتاخده معاك و انت بتقدم .. طبعا هتحتاج انترنت كارد عشان تدفع (سعر الفيزا وقت كتابة الخبرة دي 132 دولار). 2-بعد ما تدفع هتدخل على الموقع دة عشان تحجز معاد للمقابلة https://www.visainfoservices.com/ . 3- هتطلع شهادة قيد لو كنت طالب .. او ورق من شغلك بمرتبك لو كنت بتشتغل.. او بطاقتك الضريبية والسجل التجاري لو كنت صاحب عمل. 4- بنك ستيتمنت (كشف حساب) و دة مهم جدا لانه بيبين هتقدر تغطي مصاريفك هناك ولا لا. لو طالب ممكن 30 الف جنيه كافيين جدا في كشف الحساب .. في الحالات التانية مش عارف بالظبط بس اكيد لو اكتر احسن بكتير. 5-طبعا كل الورق دة يا اما يطلع انجليزي اصلا يا اما لازم تترجمه ومش لازم ترجمة معتمدة (كنت بترجمه بنفسي عالسرير واروح بيه عادي) 7-صورتين 4 في 6 خلفية بيضا زي بتاعت الباسبور. وتاخد بعضك وتروح على مكتب الوورلد بردج هتسلم ورقك وباسبورك وياخدوا بصمتك وهتستنى باسبورك هيجيلك بالدي اتش ال وعليه الفيزا ان شاء الله..";
//    String four_date = "2013-05-16";
//    /////////////////////////////////////////////////////////////////////////
//
//    String[] Name = {one_title, two_title, three_title, four_title};
//    String[] Date = {one_date, two_date, three_date, four_date};
//    String[] Description = {one_situation, two_situation, three_situation, four_situation};
//    int[] Image = {R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper, R.drawable.wallpaper};
//
//
//    private boolean mSearchViewAdded = false;
//    private MaterialSearchView mSearchView;
//    private WindowManager mWindowManager;
//    private Toolbar mToolbar;
//    private MenuItem searchItem;
//    private boolean searchActive = false;
//    private  FloatingActionButton fab;
//    ListView listView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_topdrawer);
//        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        mSearchView = new MaterialSearchView(this);
//        mSearchView.setOnSearchListener(this);
//        mSearchView.setSearchResultsListener(this);
//        listView = (ListView) findViewById(R.id.listView);
//        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
//        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
//
//        listView.setAdapter(new MAdapter(this, Name, Date, Description, Image));
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(MainActivity.this, ReviewsPopUp.class);
//                i.putExtra("name", Name[position]);
//                i.putExtra("date", Date[position]);
//                i.putExtra("description", Description[position]);
//                startActivity(i);
//               //finish();
//            } });
//
//        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//        mSearchView = new MaterialSearchView(this);
//        mSearchView.setOnSearchListener(this);
//        mSearchView.setSearchResultsListener(this);
//        mSearchView.setHintText("Search");
//
//        if (mToolbar != null) {
//            // Delay adding SearchView until Toolbar has finished loading
//            mToolbar.post(new Runnable() {
//                @Override
//                public void run() {
//                    if (!mSearchViewAdded && mWindowManager != null) {
//                        mWindowManager.addView(mSearchView,
//                                MaterialSearchView.getSearchViewLayoutParams(MainActivity.this));
//                        mSearchViewAdded = true;
//                    }
//                }
//            });
//        }
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        searchItem = menu.findItem(R.id.search);
//        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                mSearchView.display();
//                openKeyboard();
//                return true;
//            }
//        });
//        if(searchActive)
//            mSearchView.display();
//        return true;
//
//    }
//
//    private void openKeyboard(){
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0));
//                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0, 0, 0));
//            }
//        }, 200);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onSearch(String query) {
//
//    }
//
//    @Override
//    public void searchViewOpened() {
//        Toast.makeText(MainActivity.this,"Search View Opened",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void searchViewClosed() {
//        Util.showSnackBarMessage(fab,"Search View Closed");
//    }
//
//    @Override
//    public void onItemClicked(String item) {
//        Toast.makeText(MainActivity.this,item + " clicked",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onScroll() {
//
//    }
//
//    @Override
//    public void error(String localizedMessage) {
//
//    }
//
//    @Override
//    public void onCancelSearch() {
//        Util.showSnackBarMessage(fab,"Search View Cleared");
//        searchActive = false;
//        mSearchView.hide();
//    }
//        @Override
//    public void onBackPressed() {
//        if (mNavigationDrawerFragment.isDrawerOpen())
//            mNavigationDrawerFragment.closeDrawer();
//        else
//            super.onBackPressed();
//    }
//}
//
//
//
//
