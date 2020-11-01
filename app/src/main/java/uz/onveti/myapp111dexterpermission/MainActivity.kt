package uz.onveti.myapp111dexterpermission

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.OnDialogButtonClickListener
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Permission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camera_id.setOnClickListener {
            Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionGranted", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionDenied", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        p1: PermissionToken?
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "onPermissionRationaleShouldBeShown",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }).check()
        }

        read_id.setOnClickListener {
            Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionGranted", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionDenied", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        p1: PermissionToken?
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "onPermissionRationaleShouldBeShown",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }).check()
        }

        mic_id.setOnClickListener {
            Dexter.withContext(this)
                .withPermission(Manifest.permission.RECORD_AUDIO)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionGranted", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        Toast.makeText(this@MainActivity, "OnPermissionDenied", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        p1: PermissionToken?
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "onPermissionRationaleShouldBeShown",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }).check()
        }

        all_id.setOnClickListener {
            Dexter.withContext(this)
                .withPermissions(
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ).withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Multiple Permission OK",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: MutableList<PermissionRequest>?,
                        p1: PermissionToken?
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "Multiple Permission ERROR",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }).check()
        }

//        DialogOnDeniedPermissionListener.Builder
//            .withContext(this@MainActivity)                  //context
//            .withIcon(R.drawable.ic_launcher_background)    // icon
//            .withButtonText("ALLO")                        //
//            .withMessage("CAMERA PERMIS ALLO")            // messege
//            .withButtonText("XA")                        // button text
//            .build()

    }
}