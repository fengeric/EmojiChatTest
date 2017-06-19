package org.kymjs.chat.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import org.kymjs.chat.R;

import java.io.File;

public class ImageLoad {

	private Context context;
	private ImageLoaderConfiguration config;
	private ImageLoader loader = ImageLoader.getInstance();
	private DisplayImageOptions options;

	public ImageLoad(Context context) {
		this.context = context;
		initImageLoader(this.context);
	}


	// 将传递来的图片，作为默认图片
	public ImageLoad(Context context, Bitmap bitmap) {
		this.context = context;
		initImageLoaderWithBitmap(this.context, bitmap);
	}

	/**
	 * 加载原图
	 * 
	 * @param iv
	 * @param url
	 */
	public void loadImage(final ImageView iv, final String url) {
		try {

			// iv.setTag(url);
			loader.displayImage(url, iv, options);
			// loader.loadImage(url, options, new SimpleImageLoadingListener() {
			// 
			// 	@Override
			// 	public void onLoadingComplete(String imageUri, View view,
			// 			Bitmap loadedImage) {
			// 		super.onLoadingComplete(imageUri, view, loadedImage);
			// 		if (url.equals(iv.getTag())) {
			// 			if (iv != null) {
			// 				iv.setImageBitmap(loadedImage);
			// 			}
			// 		}
			// 	}
			// });
		} catch (Exception e) {
		}
	}

	/**
	 * 加载指定大小图片
	 * 
	 * @param iv
	 * @param url
	 * @param width
	 * @param height
	 */
	public void loadImage(final ImageView iv, final String url, int width,
						  int height) {
		try {
			// iv.setTag(url);
			// ImageSize imageSize = new ImageSize(width, height);
			// loader.displayImage(url, iv, options);
			// loader.loadImage(url, imageSize, options,
			// new SimpleImageLoadingListener() {
			//
			// @Override
			// public void onLoadingComplete(String imageUri,
			// View view, Bitmap loadedImage) {
			// super.onLoadingComplete(imageUri, view, loadedImage);
			// if (url.equals(iv.getTag())) {
			// iv.setImageBitmap(loadedImage);
			// }
			// }
			// });
			loader.displayImage(url, iv, options);
		} catch (Exception e) {
		}
	}

	public void clearCache() {
		try {

			if (loader != null) {
				// loader.clearDiskCache();
				loader.clearMemoryCache();
			}

		} catch (Exception e) {
		}
	}

	/**
	 * 初始化ImageLoader数据
	 */
	private void initImageLoader(Context context) {
		try {

			options = new DisplayImageOptions.Builder()
					.bitmapConfig(Bitmap.Config.RGB_565)
					.imageScaleType(ImageScaleType.EXACTLY)
					.showImageOnLoading(R.drawable.default_avater)
					.showImageForEmptyUri(R.drawable.default_avater)
					.showImageOnFail(R.drawable.default_avater)
					.cacheInMemory(true).cacheOnDisk(true).build();
			File cacheDir = StorageUtils.getCacheDirectory(context);
			// 设置缓存路径和缓存文件的数量，超过数量后，old将被删除
			config = new ImageLoaderConfiguration.Builder(context)
					.threadPoolSize(5)
					// 设定线程池的大小
					.threadPriority(Thread.NORM_PRIORITY - 1)
					.denyCacheImageMultipleSizesInMemory()
					.diskCacheSize(50 * 1024 * 1024).diskCacheFileCount(100)
					.diskCache(new UnlimitedDiskCache(cacheDir))
					.defaultDisplayImageOptions(options)
					.memoryCache(new WeakMemoryCache())
					.memoryCacheSize(2 * 1024 * 1024)
					.diskCacheFileNameGenerator(new Md5FileNameGenerator())
					.tasksProcessingOrder(QueueProcessingType.LIFO).build();
			ImageLoader.getInstance().init(config);

		} catch (Exception e) {
		}
	}
	/**
	 * 初始化ImageLoader数据
	 */
	private void initImageLoaderWithBitmap(Context context, Bitmap bitmap) {
		try {
			Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
			options = new DisplayImageOptions.Builder()
					.bitmapConfig(Bitmap.Config.RGB_565)
					.imageScaleType(ImageScaleType.EXACTLY)
					.showImageOnLoading(drawable)
					.showImageForEmptyUri(drawable)
					.showImageOnFail(drawable)
					.cacheInMemory(true).cacheOnDisk(true).build();
			File cacheDir = StorageUtils.getCacheDirectory(context);
			// 设置缓存路径和缓存文件的数量，超过数量后，old将被删除
			config = new ImageLoaderConfiguration.Builder(context)
					.threadPoolSize(5)
					// 设定线程池的大小
					.threadPriority(Thread.NORM_PRIORITY - 1)
					.denyCacheImageMultipleSizesInMemory()
					.diskCacheSize(50 * 1024 * 1024).diskCacheFileCount(100)
					.diskCache(new UnlimitedDiskCache(cacheDir))
					.defaultDisplayImageOptions(options)
					.memoryCache(new WeakMemoryCache())
					.memoryCacheSize(2 * 1024 * 1024)
					.diskCacheFileNameGenerator(new Md5FileNameGenerator())
					.tasksProcessingOrder(QueueProcessingType.LIFO).build();
			ImageLoader.getInstance().init(config);

		} catch (Exception e) {
		}
	}

}
