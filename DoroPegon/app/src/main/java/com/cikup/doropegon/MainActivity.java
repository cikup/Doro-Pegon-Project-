package com.cikup.doropegon;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    EditText abjad, pegon;
    Button btn_pegonkan, copy;
    String raw, data;
    ImageView about;


    String copyPegon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abjad = (EditText)findViewById(R.id.edt_abjad);
        btn_pegonkan = (Button)findViewById(R.id.btn_pegonkan);
        pegon = (EditText) findViewById(R.id.edt_pegon);
        copy = (Button) findViewById(R.id.btn_copy);
        about = (ImageView)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout();
            }
        });



        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pegon.length() == 0){
                    Toasty.info(MainActivity.this, "Tidak ada kata yang disalin", Toasty.LENGTH_LONG).show();
                }else {
                    copyPegon = pegon.getText().toString();
                    copyToClipboard(copyPegon);
                }

            }
        });


        btn_pegonkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (abjad.length() == 0){
                    Toasty.info(MainActivity.this, "Kata tidak boleh kosong", Toasty.LENGTH_SHORT).show();
                }else {
                    String ab = abjad.getText().toString();
                    String data = ab.toLowerCase();
                    String jadi = dataAbjad(data);

                    pegon.setText(jadi);

                }
            }
        });

    }

    private void showAbout() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("Apa itu Doro?");
        builder1.setMessage("Doro adalah sebuah mini project dari cikup untuk memudahkan penulisan pegon di dunia digital.\n\n" +
                "Contoh untuk menulis E phepet = e~ (se~kolah).\n" +
                "\n" +
                "[beta-1] 25 Dec 2018(Web)\n[beta-1] 3 Jun 2019(Android)");
        builder1.setCancelable(true);
        builder1.setNegativeButton(
                "Tutup",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void copyToClipboard(String copyText) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                    getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(copyText);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager)
                    getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData
                    .newPlainText("Your OTP", copyText);
            clipboard.setPrimaryClip(clip);
        }
        Toasty.success(MainActivity.this, "Pegon disalin!", Toasty.LENGTH_LONG).show();
    }

    public String dataAbjad(String data){

        data = data.replaceAll("^ia",  "إييا");
        data = data.replaceAll("^ua",  "أووا");

        data = data.replaceAll(" ia",  " إييا");
        data = data.replaceAll("ia",  "ييا");
        data = data.replaceAll("ua",  "ووا");

        data = data.replaceAll("nga",  "ڠا");
        data = data.replaceAll("ngi",  "ڠي");
        data = data.replaceAll("ngu",  "ڠو");
        data = data.replaceAll("nge~", "ڠَ");
        data = data.replaceAll("nge",  "ڠي");
        data = data.replaceAll("ngo",  "ڠو");

        data = data.replaceAll("nya",  "پا");
        data = data.replaceAll("nyi",  "پي");
        data = data.replaceAll("nyu",  "پو");
        data = data.replaceAll("nye~", "پَ");
        data = data.replaceAll("nye",  "پي");
        data = data.replaceAll("nyo",  "پو");

        data = data.replaceAll("ng",  "ڠ");
        data = data.replaceAll("ny",  "پ");

        data = data.replaceAll("ba",  "با");
        data = data.replaceAll("bi",  "بي");
        data = data.replaceAll("bu",  "بو");
        data = data.replaceAll("be~", "بَ");
        data = data.replaceAll("be",  "بي");
        data = data.replaceAll("bo",  "بو");

        data = data.replaceAll("ca",  "چا");
        data = data.replaceAll("ci",  "چي");
        data = data.replaceAll("cu",  "چو");
        data = data.replaceAll("ce~", "جَ");
        data = data.replaceAll("ce",  "چَي");
        data = data.replaceAll("co",  "چو");

        data = data.replaceAll("da",  "دا");
        data = data.replaceAll("di",  "دي");
        data = data.replaceAll("du",  "دو");
        data = data.replaceAll("de~", "دَ");
        data = data.replaceAll("de",  "دي");
        data = data.replaceAll("do",  "دو");

        data = data.replaceAll("fa",  "فا");
        data = data.replaceAll("fi",  "في");
        data = data.replaceAll("fu",  "فو");
        data = data.replaceAll("fe~", "فَ");
        data = data.replaceAll("fe",  "في");
        data = data.replaceAll("fo",  "فو");

        data = data.replaceAll("ga",  "ڮا");
        data = data.replaceAll("gi",  "ڮي");
        data = data.replaceAll("gu",  "ڮو");
        data = data.replaceAll("ge~", "ڮَ");
        data = data.replaceAll("ge",  "ڮي");
        data = data.replaceAll("go",  "ڮو");

        data = data.replaceAll("ha",  "ها");
        data = data.replaceAll("hi",  "هي");
        data = data.replaceAll("hu",  "هو");
        data = data.replaceAll("he~", "ه‍َ");
        data = data.replaceAll("he",  "هي");
        data = data.replaceAll("ho",  "هو");

        data = data.replaceAll("ja",  "جا");
        data = data.replaceAll("ji",  "جي");
        data = data.replaceAll("ju",  "جو");
        data = data.replaceAll("je~", "جَ");
        data = data.replaceAll("je",  "جي");
        data = data.replaceAll("jo",  "جو");

        data = data.replaceAll("ka",  "كا");
        data = data.replaceAll("ki",  "كي");
        data = data.replaceAll("ku",  "كو");
        data = data.replaceAll("ke~", "كَ");
        data = data.replaceAll("ke",  "كي");
        data = data.replaceAll("ko",  "كو");

        data = data.replaceAll("la",  "لا");
        data = data.replaceAll("li",  "لي");
        data = data.replaceAll("lu",  "لو");
        data = data.replaceAll("le~", "لَ");
        data = data.replaceAll("le",  "لي");
        data = data.replaceAll("lo",  "لو");

        data = data.replaceAll("ma",  "ما");
        data = data.replaceAll("mi",  "مي");
        data = data.replaceAll("mu",  "مو");
        data = data.replaceAll("me~", "مَ");
        data = data.replaceAll("me",  "مي");
        data = data.replaceAll("mo",  "مو");

        data = data.replaceAll("na",  "نا");
        data = data.replaceAll("ni",  "ني");
        data = data.replaceAll("nu",  "نو");
        data = data.replaceAll("ne~", "نَ");
        data = data.replaceAll("ne",  "ني");
        data = data.replaceAll("no",  "نو");

        data = data.replaceAll("pa",  "ڤا");
        data = data.replaceAll("pi",  "ڤي");
        data = data.replaceAll("pu",  "ڤو");
        data = data.replaceAll("pe~", "ڤَ");
        data = data.replaceAll("pe",  "ڤي");
        data = data.replaceAll("po",  "ڤو");

        data = data.replaceAll("qa",  "قا");
        data = data.replaceAll("qi",  "قي");
        data = data.replaceAll("qu",  "قو");
        data = data.replaceAll("qe~", "قَ");
        data = data.replaceAll("qe",  "قي");
        data = data.replaceAll("qo",  "قو");

        data = data.replaceAll("ra",  "را");
        data = data.replaceAll("ri",  "ري");
        data = data.replaceAll("ru",  "رو");
        data = data.replaceAll("re~", "رَ");
        data = data.replaceAll("re",  "ري");
        data = data.replaceAll("ro",  "رو");

        data = data.replaceAll("sa",  "سا");
        data = data.replaceAll("si",  "سي");
        data = data.replaceAll("su",  "سو");
        data = data.replaceAll("se~", "سَ");
        data = data.replaceAll("se",  "سي");
        data = data.replaceAll("so",  "سو");

        data = data.replaceAll("ta",  "تا");
        data = data.replaceAll("ti",  "تي");
        data = data.replaceAll("tu",  "تو");
        data = data.replaceAll("te~", "تَ");
        data = data.replaceAll("te",  "تي");
        data = data.replaceAll("to",  "تو");

        data = data.replaceAll("va",  "فا");
        data = data.replaceAll("vi",  "في");
        data = data.replaceAll("vu",  "فو");
        data = data.replaceAll("ve~", "فَ");
        data = data.replaceAll("ve",  "في");
        data = data.replaceAll("vo",  "فو");

        data = data.replaceAll("wa",  "وا");
        data = data.replaceAll("wi",  "وي");
        data = data.replaceAll("wu",  "وو");
        data = data.replaceAll("we~", "وَ");
        data = data.replaceAll("we",  "وي");
        data = data.replaceAll("wo",  "وو");

        data = data.replaceAll("ya",  "يا");
        data = data.replaceAll("yi",  "يي");
        data = data.replaceAll("yu",  "يو");
        data = data.replaceAll("ye~", "يَ");
        data = data.replaceAll("ye",  "يي");
        data = data.replaceAll("yo",  "يو");

        data = data.replaceAll("za",  "زا");
        data = data.replaceAll("zi",  "زي");
        data = data.replaceAll("zu",  "زو");
        data = data.replaceAll("ze~", "زَ");
        data = data.replaceAll("ze",  "زي");
        data = data.replaceAll("zo",  "زو");

        data = data.replaceAll("b",  "ب");
        data = data.replaceAll("c",  "ج");
        data = data.replaceAll("d",  "د");
        data = data.replaceAll("f",  "ف");
        data = data.replaceAll("g",  "ڮ");
        data = data.replaceAll("h",  "ه");
        data = data.replaceAll("j",  "ج");
        data = data.replaceAll("k",  "ك");
        data = data.replaceAll("l",  "ل");
        data = data.replaceAll("m",  "م");
        data = data.replaceAll("n",  "ن");
        data = data.replaceAll("p",  "ڤ");
        data = data.replaceAll("q",  "ق");
        data = data.replaceAll("r",  "ر");
        data = data.replaceAll("s",  "س");
        data = data.replaceAll("t",  "ت");
        data = data.replaceAll("v",  "ف");
        data = data.replaceAll("w",  "و");
        data = data.replaceAll("y",  "ي");
        data = data.replaceAll("z",  "ز");

        data = data.replaceAll("a",  "أ");
        data = data.replaceAll("i",  "إي");
        data = data.replaceAll("u",  "أو");
        data = data.replaceAll("e~", "أَ");
        data = data.replaceAll("e",  "أي");
        data = data.replaceAll("o",  "أو");

//        data = data.replaceAll("?",  "؟");
        return data;
    }

}
