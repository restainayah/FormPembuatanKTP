package id.sch.smktelkom_mlg.tugas01.xiirpl2032.formpembuatanktp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTTL, etPekerjaan, etAlamat;
    Button bOk;
    String nama, ttl, pekerjaan, alamat;
    TextView tvHasil;
    CheckBox cbB, cbPP, cbPG;
    //RadioButton rbM, rbBM, rbJ,rbD;
    RadioGroup rgStatus, rgJK;
    Spinner spAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTTL = (EditText) findViewById(R.id.editTextTTL);
        etPekerjaan = (EditText) findViewById(R.id.editTextPekerjaan);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);

        cbB = (CheckBox) findViewById(R.id.checkBoxBaru);
        cbPP = (CheckBox) findViewById(R.id.checkBoxPerpanjangan);
        cbPG = (CheckBox) findViewById(R.id.checkBoxPergantian);

        /*rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rbBM = (RadioButton) findViewById(R.id.radioButtonBM);
        rbJ = (RadioButton) findViewById(R.id.radioButtonJ);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);*/

        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);

        spAgama = (Spinner) findViewById(R.id.spinnerAgama);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);

        bOk = (Button) findViewById(R.id.buttonOk);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        nama = etNama.getText().toString();
        ttl = etTTL.getText().toString();
        pekerjaan = etPekerjaan.getText().toString();
        alamat = etAlamat.getText().toString();

        String hasil = "Permohonan KTP : ";
        int startlen = hasil.length();
        if (cbB.isChecked()) hasil += cbB.getText().toString() + "\n";
        if (cbPP.isChecked()) hasil += cbPP.getText().toString() + "\n";
        if (cbPG.isChecked()) hasil += cbPG.getText().toString() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada Pilihan";

        String hsl = null;

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hsl = rb.getText().toString();
        }
        if (hsl == null) {
            tvHasil.setText("Belum Memilih Status");
        }

        String hsll = null;

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rbt = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hsll = rbt.getText().toString();
        }
        if (hsll == null) {
            tvHasil.setText("Belum Memilih Jenis Kelamin");
        }


        tvHasil.setText("Permohonan KTP : " + hasil +
                "Nama : " + nama + "\n" +
                "Tempat, Tanggal Lahir : " + ttl + "\n" +
                "Status Anda : " + hsl + "\n" +
                "Pekerjaan : " + pekerjaan + "\n" +
                "Alamat : " + alamat + "\n" +
                "Agama : " + spAgama.getSelectedItem().toString() + "\n" +
                "Jenis Kelamin : " + hsll + "\n");


    }
}
