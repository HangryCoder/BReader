package genora.example.com.breader.model

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Book(val book_id: Int, val book_name: String,
                val front_cover_path: String, val best_seller_count: Int,
                val featured: Int, val product_key: Int, val price: String,
                val pdf_path: String, val sample_pdf_path: String)